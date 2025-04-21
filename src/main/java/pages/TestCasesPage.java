package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class TestCasesPage extends BasePage {
    private static final SelenideElement SECTION_DESCRIPTION = $x("//*[@data-testid='sectionDescription']");
    private static final SelenideElement ADD_CASE_BUTTON = $x("//span[@data-testid = 'suiteAddCaseLink']");
    private static final String TEST_CASE_CHECKBOX = "//*[@type='checkbox' and @value='%s']";
    private static final SelenideElement DELETE_BUTTON = $(By.id("deleteCases"));
    private static final SelenideElement DISPLAY_DELETED_TEST_CASES_BUTTON = $x("//*[@class='button-text' and contains(text(), 'Display Deleted Test Cases')]");

    public TestCasesPage() {
    }

    /**
     * This method is used to open the test cases page.
     * @param suiteId - the ID of the test suite.
     * @return - the current instance of TestCasesPage.
     */
    public TestCasesPage openTestCasesPage(int suiteId) {
        log.info("Opening test cases page");
        open(String.format(TEST_CASES_URL_UI, suiteId));
        return this;
    }

    /**
     * This method is used to check if the Test Cases page is opened.
     * @return - the current instance of TestCasesPage.
     */
    public TestCasesPage isOpened() {
        SECTION_DESCRIPTION.shouldBe(Condition.visible);
        return this;
    }

    /**
     * This method is used to click on the 'Add Case' button.
     * @return - the instance of AddOrEditTestCasePage.
     */
    public AddOrEditTestCasePage clickAddCaseButton() {
        log.info("Clicking on 'Add Case' button");
        new Button().click(ADD_CASE_BUTTON);
        return new AddOrEditTestCasePage();
    }

    /**
     * This method is used to select a test case checkbox by its ID.
     * @param testCaseId - the ID of the test case.
     * @return - the section description.
     */
    public TestCasesPage selectTestCaseCheckboxByTestCaseId(String testCaseId) {
        log.info("Selecting test case with ID: " + testCaseId);
        $x(String.format(TEST_CASE_CHECKBOX, testCaseId)).click();
        return this;
    }

    /**
     * This method is used to check if a test case exists by its ID.
     * @param testCaseId - the ID of the test case.
     * @return - true if the test case exists, false otherwise.
     */
    public boolean isTestCaseExistByTestCaseId(String testCaseId) {
        log.info("Checking if test case with ID: " + testCaseId + " exists");
        return $x(String.format(TEST_CASE_CHECKBOX, testCaseId)).isDisplayed();
    }

    /**
     * This method is used to click on the 'Delete' button.
     * @return - the instance of DialogConfirmationPage.
     */
    public DialogConfirmationPage clickDeleteButton() {
        log.info("Clicking on 'Delete' button");
        new Button().click(DELETE_BUTTON);
        return new DialogConfirmationPage();
    }

    /**
     * This method is used to click on the 'Display Deleted Test Cases' button.
     * @return - the current instance of TestCasesPage.
     */
    public TestCasesPage clickDisplayDeletedTestCasesButton() {
        log.info("Clicking on 'Display Deleted Test Cases' button");
        new Button().click(DISPLAY_DELETED_TEST_CASES_BUTTON);
        return this;
    }
}