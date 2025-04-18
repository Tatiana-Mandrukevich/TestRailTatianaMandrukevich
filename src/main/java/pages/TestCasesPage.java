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

    public TestCasesPage openTestCasesPage(int suiteId) {
        log.info("Opening test cases page");
        open(String.format(TEST_CASES_URL_UI, suiteId));
        return this;
    }

    public TestCasesPage isOpened() {
        SECTION_DESCRIPTION.shouldBe(Condition.visible);
        return this;
    }

    public AddOrEditTestCasePage clickAddCaseButton() {
        log.info("Clicking on 'Add Case' button");
        new Button().click(ADD_CASE_BUTTON);
        return new AddOrEditTestCasePage();
    }

    public TestCasesPage selectTestCaseCheckboxByTestCaseId(String testCaseId) {
        log.info("Selecting test case with ID: " + testCaseId);
        $x(String.format(TEST_CASE_CHECKBOX, testCaseId)).click();
        return this;
    }

    public boolean isTestCaseExistByTestCaseId(String testCaseId) {
        log.info("Checking if test case with ID: " + testCaseId + " exists");
        return $x(String.format(TEST_CASE_CHECKBOX, testCaseId)).isDisplayed();
    }

    public DialogConfirmationPage clickDeleteButton() {
        log.info("Clicking on 'Delete' button");
        new Button().click(DELETE_BUTTON);
        return new DialogConfirmationPage();
    }

    public TestCasesPage clickDisplayDeletedTestCasesButton() {
        log.info("Clicking on 'Display Deleted Test Cases' button");
        new Button().click(DISPLAY_DELETED_TEST_CASES_BUTTON);
        return this;
    }
}