package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class TestCasePage extends AddTestCasePage {
    private static final SelenideElement EDIT_BUTTON = $x("//*[@data-testid='testCaseEditButton']");
    private static final SelenideElement TITLE = $x("//*[@data-testid='testCaseContentHeaderTitle']");
    private static final SelenideElement SECTION = $x("//div[@class='content-breadcrumb']//a");
    private static final String TEST_CASE_PARAMETER = "//label[text()='%s']/parent::*";
    private static final SelenideElement PRECONDITIONS = $x("//div[@class='markdown']");
    private static final String STEP_DESCRIPTION = "//span[@class='step-index-inner ' and contains(text(), '%s')]//ancestor::tr//div[@class='markdown content like-textarea step_load steps-view']//p";
    private static final String EXPECTED_RESULT = "//span[@class='step-index-inner ' and contains(text(), '%s')]//ancestor::tr//div[@class='markdown expected like-textarea step_load steps-view']//p";

    public TestCasePage isOpened() {
        EDIT_BUTTON.shouldBe(Condition.visible);
        return this;
    }

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

    public String getTestCaseSection() {
        try {
            log.info("Getting an existing section");
            return SECTION.shouldBe(Condition.visible).getText();
        } catch (Exception e) {
            log.error("Error getting the test case section: {}", e.getMessage());
            return null;
        }
    }

    public String getTestCaseParameter(String parameter) {
        try {
            log.info("Getting an existing parameter: " + parameter);
            return $x(String.format(TEST_CASE_PARAMETER, parameter)).shouldBe(Condition.visible).getText();
        } catch (Exception e) {
            log.error("Error getting the test case parameter: {}", e.getMessage());
            return null;
        }
    }

    public String getTestCasePreconditions() {
        try {
            log.info("Getting an existing preconditions");
            return PRECONDITIONS.shouldBe(Condition.visible).getText();
        } catch (Exception e) {
            log.error("Error getting the test case preconditions: {}", e.getMessage());
            return null;
        }
    }

    public String getStepDescription(String stepNumber) {
        try {
            log.info("Getting an existing step description");
            return $x(String.format(STEP_DESCRIPTION, stepNumber)).getText();
        } catch (Exception e) {
            log.error("Error getting the step description: {}", e.getMessage());
            return null;
        }
    }

    public String getExpectedResult(String stepNumber) {
        try {
            log.info("Getting an existing expected result");
            return $x(String.format(EXPECTED_RESULT, stepNumber)).getText();
        } catch (Exception e) {
            log.error("Error getting the expected result: {}", e.getMessage());
            return null;
        }
    }
}