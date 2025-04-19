package steps;

import adapters.SectionAdapter;
import entity.TestCase;
import io.qameta.allure.Step;
import java.time.LocalDateTime;
import pages.AddOrEditTestCasePage;

public class AddOrEditTestCaseSteps extends BaseSteps {

    AddOrEditTestCasePage addTestCasePage;
    SectionAdapter sectionAdapter;

    public AddOrEditTestCaseSteps(AddOrEditTestCasePage addTestCasePage, SectionAdapter sectionAdapter) {
        this.addTestCasePage = addTestCasePage;
        this.sectionAdapter = sectionAdapter;
    }

    @Step("Add test case")
    public TestCase addTestCase(TestCase testCase) {
        addTestCasePage.createTestCase(testCase);
        return testCase;
    }

    @Step("Update test case")
    public TestCase updateTestCase(TestCase testCase) {
        addTestCasePage.updateTestCase(testCase);
        return testCase;
    }
}