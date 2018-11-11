import Pages.SignUpPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;
import Steps.SignUpSteps;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WhenSignUp {

    @Steps
    SignUpSteps steps;

    @Managed
    WebDriver driver;

    @Test
    public void typeInvalidYear() {
        steps.open_signup_page();
        steps.set_month("December");
        steps.set_day("20");
        steps.set_year("85");
        steps.set_share(true);
        steps.should_see_error("Please enter a valid year.");
        steps.should_not_see_error("When were you born?");

    }

    @Test
    public void typeInvalidEmail() {

        steps.open_signup_page();
        steps.type_email("qwe@gmail.com");
        steps.type_confirmation_email("ghkhjk@gmail.com");
        steps.type_name("TestName");
        steps.click_signup();
        steps.should_see_error("We're sorry, that email is taken.");


    }

    @Test
    public void signUpWithEmptyPassword() {

        steps.open_signup_page();
        steps.type_email("test@test.com");
        steps.type_confirmation_email("test@test.com");
        steps.type_name("TestName");
        steps.click_signup();


        steps.should_see_error("We're sorry, that email is taken.");
    }

    @Test
    public void typeInvalidValues() {

        steps.open_signup_page();
        steps.type_email("testmail");
        steps.type_confirmation_email("wrongmail");
        steps.type_password("nameForExample");
        steps.select_sex("Male");
        steps.set_share(false);
        steps.click_signup();
        steps.should__see_errors_count(2);
        steps.should__see_errors_by_number(2, "The email address you supplied is invalid.");

    }
}
