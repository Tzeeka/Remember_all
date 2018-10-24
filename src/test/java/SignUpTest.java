import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class SignUpTest extends BaseTest {

    @Test
    public void typeInvalidYear() {
        SignUpPage page = new SignUpPage();
        page.open()
                .setMonth("December")
                .typeDay("20")
                .typeYear("85")
                .setShare(true);
        page.getError("Please enter a valid year.").shouldBe(visible);
        page.getError("When were you born?").shouldNotBe(visible);
    }

    @Test
    public void typeInvalidEmail() {
        SignUpPage page = new SignUpPage();
        page.open()
                .typeEmail("qwe@gmail.com")
                .typeConfirmEmail("ghkhjk@gmail.com")
                .typeNameField("TestName")
                .clickSignUpButton();
        page.getError("We're sorry, that email is taken.").shouldBe(visible);
    }

    @Test
    public void signUpWithEmptyPassword() {
        SignUpPage page = new SignUpPage();
        page.open()
                .typeEmail("test@test.com")
                .typeConfirmEmail("test@test.com")
                .typeNameField("TestName")
                .clickSignUpButton();
        page.getError("We're sorry, that email is taken.").shouldBe(visible);
    }

    @Test
    public void typeInvalidValues() {
        SignUpPage page = new SignUpPage();
        page.open()
                .typeEmail("testmail")
                .typeConfirmEmail("wrongmail")
                .typePassword("wefwef123")
                .typeNameField("nameForExample")
                .setSex("Male")
                .setShare(false)
                .clickSignUpButton();
        page.getErrors().shouldHave(size(2));
        page.getErrorByNumber(2).shouldHave(text("The email address you supplied is invalid."));

    }
}
