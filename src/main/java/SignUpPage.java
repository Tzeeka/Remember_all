import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SignUpPage {
    private WebDriver driver;
    static WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


   private By emailField = By.id("register-email");
   private By confirmEmailField = By.id("register-confirm-email");
   private By registerPasswordField = By.id("register-password");
   private By nameField = By.id("register-displayname");
   private By monthDropDown = By.id("register-dob-month");
   private By signUpPage = By.id("nav-link-sign-up");


   private final static String monthDropDownOption = ".//select[@id='register-dob-month']/option[text()='%s']";

   private By dayField = By.id("register-dob-day");
   private By yearField = By.id("register-dob-year");
   String sexRadioButton = "//li[@id='li-gender']/label[normalize-space()='%s']/input";

   /*private By sexRadioButtonMale = By.id("register-male");
   private By sexRadioButtonFemale = By.id("register-female");
   private By sexRadioButtonNonBinary = By.id("register-neutral");*/

   private By checkBox1 = By.id("register-thirdparty");
   private By registerButton = By.id("register-thirdparty");
   private By errorLabel = xpath("//label[@class=\"has-error\" and string-length(text())>0]");
   private String errorByText = "//label[@class=\"has-error\" and text()=\"%s\"]";

   public SignUpPage goToSignUpPage() {
       driver.findElement(signUpPage).click();
       return this;
   }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String email) {
        driver.findElement(confirmEmailField).sendKeys(email);
        return this;
    }

     public SignUpPage typePassword(String password) {
        driver.findElement(registerPasswordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public SignUpPage setMonth(String month) {
        driver.findElement(monthDropDown).click();
        wait.until(visibilityOfElementLocated(xpath(format(monthDropDownOption, month)))).click();
        return this;
    }

    public SignUpPage typeDay(String day) {
        driver.findElement(dayField).sendKeys(day);
        return this;
    }

    public SignUpPage typeYear(String year) {
        driver.findElement(yearField).sendKeys(year);
        return this;
    }

    public SignUpPage setSex(String value) {
        driver.findElement(xpath(format(sexRadioButton, value))).click();
        return this;
    }

    public SignUpPage setShare (boolean value) {
        WebElement checkbox = driver.findElement(checkBox1);
        if(!checkbox.isSelected() == value) {
            checkbox.click();
        }

        return this;
    }

    public void clickSignUpButton() {
        driver.findElement(registerButton).click();
    }

    public List<WebElement> getErrors() {
        return driver.findElements(errorLabel);
    }

    public String getErrorByNumber(int number) {
        return getErrors().get(number - 1).getText();
    }

    public boolean isErrorVisible(String message) {
        return driver.findElements(xpath(format(errorByText, message))).size() > 0
                && driver.findElements(xpath(format(errorByText, message))).get(0).isDisplayed();
    }



}
