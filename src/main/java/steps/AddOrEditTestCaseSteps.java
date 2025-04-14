package steps;

import adapters.SectionAdapter;
import entity.TestCase;
import io.qameta.allure.Step;
import pages.AddOrEditTestCasePage;

public class AddOrEditTestCaseSteps extends BaseSteps {

    AddOrEditTestCasePage addTestCasePage;
    SectionAdapter sectionAdapter;

    public AddOrEditTestCaseSteps(AddOrEditTestCasePage addTestCasePage, SectionAdapter sectionAdapter) {
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
                .estimate("1 hour")
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

    @Step("Update test case")
    public TestCase updateTestCase() {
        TestCase testCase = TestCase.builder()
                .title("Test Case Title value updated " + System.currentTimeMillis())
                .section(sectionAdapter.getCreatedSectionName())
                .template("Test Case (Steps)")
                .type("Automated")
                .priority("Critical")
                .assignedTo("None")
                .estimate("2 hours")
                .references("References value updated")
                .automationType("None")
                .preconditions("Preconditions value updated")
                .stepDescriptionForFirstStep("Step Description value for 1 step updated")
                .expectedResultForFirstStep("Expected Result value for 1 step updated")
                .stepDescriptionForSecondStep("Step Description value for 2 step updated")
                .expectedResultForSecondStep("Expected Result value for 2 step updated")
                .build();

        addTestCasePage.updateTestCase(testCase);
        return testCase;
    }
}