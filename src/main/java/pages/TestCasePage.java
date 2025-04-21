package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class TestCasePage extends AddOrEditTestCasePage {
    private static final SelenideElement EDIT_BUTTON = $x("//*[@data-testid='testCaseEditButton']");
    private static final SelenideElement TITLE = $x("//*[@data-testid='testCaseContentHeaderTitle']");
    private static final SelenideElement SECTION = $x("//div[@class='content-breadcrumb']//a");
    private static final String TEST_CASE_PARAMETER = "//label[text()='%s']/parent::*";
    private static final SelenideElement PRECONDITIONS = $x("//div[@class='markdown']");
    private static final String STEP_DESCRIPTION = "//span[@class='step-index-inner ' and contains(text(), '%s')]//ancestor::tr//div[@class='hidden-vertical']//p";
    private static final String EXPECTED_RESULT = "//span[@class='step-index-inner ' and contains(text(), '%s')]//ancestor::tr//td[@class='step-content hidden-vertical']//p";
    private static final SelenideElement TEST_CASE_ID = $x("//*[@data-testid='contentHeaderId']");

    /**
     * This method is used to check if the Test Case page is opened.
     * @return - the current instance of TestCasePage.
     */
    public TestCasePage isOpened() {
        EDIT_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    /**
     * This method is used to get the title of the test case.
     * @return - the title of the test case.
     */
    public String getTestCaseTitle() {
        try {
            log.info("Getting an existing title");
            return TITLE.shouldBe(Condition.visible).getText();
        }
        catch (Exception e) {
            log.error("Error getting the test case title: {}", e.getMessage());
            return null;
        }
    }

    /**
     * This method is used to get the section of the test case.
     * @return - the section of the test case.
     */
    public String getTestCaseSection() {
        try {
            log.info("Getting an existing section");
            return SECTION.shouldBe(Condition.visible).getText();
        } catch (Exception e) {
            log.error("Error getting the test case section: {}", e.getMessage());
            return null;
        }
    }

    /**
     * This method is used to get the test case parameter.
     * @param parameter - the name of the parameter.
     * @return - the value of the parameter.
     */
    public String getTestCaseParameter(String parameter) {
        try {
            log.info("Getting an existing parameter: " + parameter);
            String text = $x(String.format(TEST_CASE_PARAMETER, parameter)).shouldBe(Condition.visible).getText();;
            String[] lines = text.split("\n");
            return lines[1];
        } catch (Exception e) {
            log.error("Error getting the test case parameter: {}", e.getMessage());
            return null;
        }
    }

    /**
     * This method is used to get the preconditions of the test case.
     * @return - the preconditions of the test case.
     */
    public String getTestCasePreconditions() {
        try {
            log.info("Getting an existing preconditions");
            return PRECONDITIONS.shouldBe(Condition.visible).getText();
        } catch (Exception e) {
            log.error("Error getting the test case preconditions: {}", e.getMessage());
            return null;
        }
    }

    /**
     * This method is used to get the step description of the test case.
     * @param stepNumber - the number of the step.
     * @return - the step description.
     */
    public String getStepDescription(String stepNumber) {
        try {
            log.info("Getting an existing step description");
            return $x(String.format(STEP_DESCRIPTION, stepNumber)).getText();
        } catch (Exception e) {
            log.error("Error getting the step description: {}", e.getMessage());
            return null;
        }
    }

    /**
     * This method is used to get the expected result of the test case.
     * @param stepNumber - the number of the step.
     * @return - the expected result.
     */
    public String getExpectedResult(String stepNumber) {
        try {
            log.info("Getting an existing expected result");
            return $x(String.format(EXPECTED_RESULT, stepNumber)).getText();
        } catch (Exception e) {
            log.error("Error getting the expected result: {}", e.getMessage());
            return null;
        }
    }

    /**
     * This method is used to get the test case ID.
     * @return - the test case ID.
     */
    public String getTestCaseId() {
        try {
            log.info("Getting an existing test case ID");
            return TEST_CASE_ID.shouldBe(Condition.visible).getText().substring(1);
        } catch (Exception e) {
            log.error("Error getting the test case ID: {}", e.getMessage());
            return null;
        }
    }

    /**
     * This method is used to click on the 'Edit' button.
     * @return - an instance of AddOrEditTestCasePage.
     */
    public AddOrEditTestCasePage clickEditButton() {
        log.info("Clicking on 'Edit' button");
        new Button().click(EDIT_BUTTON);
        return new AddOrEditTestCasePage();
    }

    /**
     * This method is used to click on the section name.
     * @return - an instance of TestCasesPage.
     */
    public TestCasesPage clickSectionName() {
        log.info("Clicking on a section name");
        new Button().click(SECTION);
        return new TestCasesPage();
    }
}