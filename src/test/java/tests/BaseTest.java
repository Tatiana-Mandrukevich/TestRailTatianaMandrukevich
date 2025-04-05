package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import pages.AllProjectsPage;
import pages.LoginPage;
import steps.LoginSteps;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    protected LoginSteps loginSteps;
    protected AllProjectsPage allProjectsPage;
    protected LoginPage loginPage;
    SoftAssert softAssert = new SoftAssert();

    public void initPages() {
        loginSteps = new LoginSteps();
        allProjectsPage = new AllProjectsPage();
        loginPage = new LoginPage();
    }

    @BeforeMethod
    public void initTest() {

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.browserSize = "1024x768";

        initPages();
    }

    /**
     * It is quitting the WebDriver.
     */
    @AfterMethod
    public void endTest() {
        getWebDriver().quit();
    }
}