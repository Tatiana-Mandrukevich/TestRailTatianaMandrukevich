package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;
import entity.TestCase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AddOrEditTestCasePage extends TestCasesPage {
    private static final SelenideElement ADD_OR_SAVE_TEST_CASE_BUTTON = $(By.id("accept"));
    private static final SelenideElement ADD_STEP_BUTTON = $x("//*[@data-testid = 'addEditCaseAddStep']");

    /**
     * This method is used to check if the Add or Edit Test Case page is opened.
     * @return - the current instance of AddOrEditTestCasePage.
     */
    public AddOrEditTestCasePage isOpened() {
        ADD_OR_SAVE_TEST_CASE_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    /**
     * This method is used to create a new test case.
     * @param testCase - test case to be created.
     * @return TestCasePage
     */
    public TestCasePage createTestCase(TestCase testCase) {
        new Input("title").write(testCase.getTitle());
        new Dropdown("section_id_chosen").selectOptionFromDropdown(testCase.getSection());
        new Dropdown("template_id_chosen").selectOptionFromDropdown(testCase.getTemplate());
        new Dropdown("type_id_chosen").selectOptionFromDropdown(testCase.getType());
        new Dropdown("priority_id_chosen").selectOptionFromDropdown(testCase.getPriority());
        new Dropdown("assigned_to_id_chosen").selectOptionFromDropdown(testCase.getAssignedTo());
        new Input("estimate").write(testCase.getEstimate());
        new Input("refs").write(testCase.getReferences());
        new Dropdown("custom_automation_type_chosen").selectOptionFromDropdown(testCase.getAutomationType());
        new Input("custom_preconds_display").write(testCase.getPreconditions());
        new Button().click(ADD_STEP_BUTTON);
        new Input("Step Description").writeSteps("1", testCase.getStepDescriptionForFirstStep());
        new Input("Expected Result").writeSteps("2", testCase.getExpectedResultForFirstStep());
        new Button().click(ADD_STEP_BUTTON);
        new Input("Step Description").writeSteps("3", testCase.getStepDescriptionForSecondStep());
        new Input("Expected Result").writeSteps("4", testCase.getExpectedResultForSecondStep());
        new Button().click(ADD_OR_SAVE_TEST_CASE_BUTTON);
        return new TestCasePage();
    }

    /**
     * This method is used to update an existing test case.
     * @param testCase - updated test case.
     * @return TestCasePage
     */
    public TestCasePage updateTestCase(TestCase testCase) {
        new Input("title").clear();
        new Input("title").write(testCase.getTitle());
        new Dropdown("section_id_chosen").selectOptionFromDropdown(testCase.getSection());
        new Dropdown("template_id_chosen").selectOptionFromDropdown(testCase.getTemplate());
        new Dropdown("type_id_chosen").selectOptionFromDropdown(testCase.getType());
        new Dropdown("priority_id_chosen").selectOptionFromDropdown(testCase.getPriority());
        new Dropdown("assigned_to_id_chosen").selectOptionFromDropdown(testCase.getAssignedTo());
        new Input("estimate").clear();
        new Input("estimate").write(testCase.getEstimate());
        new Input("refs").clear();
        new Input("refs").write(testCase.getReferences());
        new Dropdown("custom_automation_type_chosen").selectOptionFromDropdown(testCase.getAutomationType());
        new Input("custom_preconds_display").clear();
        new Input("custom_preconds_display").write(testCase.getPreconditions());
        new Input("Step Description").clearSteps("2");
        new Input("Step Description").writeSteps("2", testCase.getStepDescriptionForFirstStep());
        new Input("Expected Result").clearSteps("3");
        new Input("Expected Result").writeSteps("3", testCase.getExpectedResultForFirstStep());
        new Input("Step Description").clearSteps("4");
        new Input("Step Description").writeSteps("4", testCase.getStepDescriptionForSecondStep());
        new Input("Expected Result").clearSteps("5");
        new Input("Expected Result").writeSteps("5", testCase.getExpectedResultForSecondStep());
        new Button().click(ADD_OR_SAVE_TEST_CASE_BUTTON);
        return new TestCasePage();
    }
}