import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class ConfigTest {

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverRunner.setWebDriver(new ChromeDriver(options));
        Configuration.browserSize = null;
        Configuration.browser = "chrome";
        timeout=10000;
        holdBrowserOpen=false;
        baseUrl = "https://www.swoop.ge/";
        Configuration.browserCapabilities = options;
        open(baseUrl);

    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown(){
//        Selenide.closeWebDriver();
//    }

}
