package tests;

import adapters.ProjectAdapter;
import adapters.SectionAdapter;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.*;
import tests.constants.ITestConstants;
import tests.utils.TestListener;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Listeners(TestListener.class)
public class BaseTest implements ITestConstants {
    protected LoginSteps loginSteps;
    protected AllProjectsPage allProjectsPage;
    protected LoginPage loginPage;
    protected ProjectAdapter projectAdapter;
    protected SectionAdapter sectionAdapter;
    protected ProjectSteps projectSteps;
    protected SectionSteps sectionSteps;
    protected TestCasePage testCasePage;
    protected TestCaseSteps testCaseSteps;
    protected TestCasesPage testCasesPage;
    protected TestCasesSteps testCasesSteps;
    protected AddOrEditTestCasePage addTestCasePage;
    protected AddOrEditTestCaseSteps addTestCaseSteps;
    protected DialogConfirmationPage dialogConfirmationPage;
    protected DialogConfirmationSteps dialogConfirmationSteps;

    public void initPages() {
        loginPage = new LoginPage();
        loginSteps = new LoginSteps(loginPage);
        allProjectsPage = new AllProjectsPage();
        projectAdapter = new ProjectAdapter();
        sectionAdapter = new SectionAdapter();
        projectSteps = new ProjectSteps(projectAdapter);
        sectionSteps = new SectionSteps(sectionAdapter, projectAdapter);
        testCasePage = new TestCasePage();
        testCaseSteps = new TestCaseSteps(testCasePage);
        testCasesPage = new TestCasesPage();
        testCasesSteps = new TestCasesSteps(testCasesPage, sectionAdapter, testCasePage);
        addTestCasePage = new AddOrEditTestCasePage();
        addTestCaseSteps = new AddOrEditTestCaseSteps(addTestCasePage, sectionAdapter);
        dialogConfirmationPage = new DialogConfirmationPage();
        dialogConfirmationSteps = new DialogConfirmationSteps(dialogConfirmationPage);
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

    @AfterClass(enabled = true)
    public void deleteTestProjects() {
        projectAdapter.deleteTestProjectsByAnnouncementValue("Project announcement value", "Project announcement value updated");
    }
}