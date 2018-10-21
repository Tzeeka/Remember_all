import org.junit.Assert;
import org.junit.Test;

public class SignUpTest extends BaseTest {

    @Test
    public void typeInvalidYear() {
        SignUpPage page = new SignUpPage(driver);
        page.setMonth("December")
                .typeDay("20")
                .typeYear("85")
                .setShare(true);
        Assert.assertTrue(page.isErrorVisible("Please enter a valid year."));
        Assert.assertFalse(page.isErrorVisible("When were you born?"));
    }

    @Test
    public void typeInvalidEmail() {
        SignUpPage page = new SignUpPage(driver);
        page.typeEmail("qwe@gmail.com")
                .typeConfirmEmail("ghkhjk@gmail.com")
                .typeNameField("TestName")
                .clickSignUpButton();

        Assert.assertTrue(page.isErrorVisible("We're sorry, that email is taken."));
    }

    @Test
    public void signUpWithEmptyPassword() {
        SignUpPage page = new SignUpPage(driver);
        page.typeEmail("test@test.com")
                .typeConfirmEmail("test@test.com")
                .typeNameField("TestName")
                .clickSignUpButton();
        Assert.assertTrue(page.isErrorVisible("We're sorry, that email is taken."));
    }

    @Test
    public void typeInvalidValues() {
        SignUpPage page = new SignUpPage(driver);
        page.typeEmail("testmail")
                .typeConfirmEmail("wrongmail")
                .typePassword("wefwef123")
                .typeNameField("nameForExample")
                .setSex("Male")
                .setShare(false)
                .clickSignUpButton();
        Assert.assertEquals(2, page.getErrors().size());
        Assert.assertEquals("The email address you supplied is invalid.", page.getErrorByNumber(2));


    }
}
