
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;

public class BaseTest {

    static public WebDriverWait wait;

    @BeforeClass
    public static void start() {

        WebDriverManager.chromedriver().setup();
        baseUrl = "https://www.spotify.com/int/signup";
        browser = "chrome";
    }


}