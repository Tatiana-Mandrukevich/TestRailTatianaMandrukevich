package steps;

import adapters.SectionAdapter;
import entity.TestCase;
import io.qameta.allure.Step;
import pages.AddTestCasePage;

public class AddTestCaseSteps extends BaseSteps {

    AddTestCasePage addTestCasePage;
    SectionAdapter sectionAdapter;

    public AddTestCaseSteps(AddTestCasePage addTestCasePage, SectionAdapter sectionAdapter) {
        this.addTestCasePage = addTestCasePage;
        this.sectionAdapter = sectionAdapter;
    }

    @Step("Add test case")
    public TestCase addTestCase() {
        TestCase testCase = TestCase.builder()
                .title("Test Case Title value " + System.currentTimeMillis())
                .section(sectionAdapter.getCreatedSectionName())
                .template("Test Case (Steps)")
                .type("Functional")
                .priority("High")
                .assignedTo("Me")
                .estimate("1h")
                .references("References value")
                .automationType("Ranorex")
                .preconditions("Preconditions value")
                .stepDescriptionForFirstStep("Step Description value for 1 step")
                .expectedResultForFirstStep("Expected Result value for 1 step")
                .stepDescriptionForSecondStep("Step Description value for 2 step")
                .expectedResultForSecondStep("Expected Result value for 2 step")
                .build();

        addTestCasePage.createTestCase(testCase);
        return testCase;
    }
}