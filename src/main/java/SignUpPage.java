import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;
import com.codeborne.selenide.*;


public class SignUpPage {
   private By emailField = By.id("register-email");
   private By confirmEmailField = By.id("register-confirm-email");
   private By registerPasswordField = By.id("register-password");
   private By nameField = By.id("register-displayname");
   private By monthDropDown = By.id("register-dob-month");
   private By signUpPage = By.id("nav-link-sign-up");


   private final static String monthDropDownOption = ".//select[@id='register-dob-month']/option[text()='%s']";

   private By dayField = By.id("register-dob-day");
   private By yearField = By.id("register-dob-year");
   String sexRadioButton = "//li[@id='li-gender']/label[normalize-space()='%s']";
   private By checkBox1 = By.id("register-thirdparty");
   private By registerButton = By.id("register-thirdparty");
   private By errorLabel = xpath("//label[@class=\"has-error\" and string-length(text())>0]");
   private String errorByText = "//label[@class=\"has-error\" and text()=\"%s\"]";

   public SignUpPage open() {
       Selenide.open("/");
       return this;
   }

   public SignUpPage goToSignUpPage() {
       $(signUpPage).click();
       return this;
   }

    public SignUpPage typeEmail(String email) {
        $(emailField).setValue(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String email) {
        $(confirmEmailField).setValue(email);
        return this;
    }

     public SignUpPage typePassword(String password) {
        $(registerPasswordField).setValue(password);
        return this;
    }

    public SignUpPage typeNameField(String name) {
        $(nameField).setValue(name);
        return this;
    }

    public SignUpPage setMonth(String month) {
        $(monthDropDown).selectOption(month);
        return this;
    }

    public SignUpPage typeDay(String day) {
        $(dayField).setValue(day);
        return this;
    }

    public SignUpPage typeYear(String year) {
        $(yearField).setValue(year);
        return this;
    }

    public SignUpPage setSex(String value) {
        $(By.xpath(format(sexRadioButton, value))).click();
        return this;
    }

    public SignUpPage setShare (boolean value) {
       $(checkBox1).setSelected(value);
        return this;
    }

    public void clickSignUpButton() {
        $(registerButton).click();
    }

    public ElementsCollection getErrors() {
        return $$(errorLabel);
    }

    public SelenideElement getErrorByNumber(int number) {
        return getErrors().get(number - 1);
    }

    public SelenideElement getError(String message) {
        return $(xpath(format(errorByText, message)));
    }

}
