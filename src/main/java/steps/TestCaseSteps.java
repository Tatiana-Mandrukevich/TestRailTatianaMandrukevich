package steps;

import entity.TestCase;
import io.qameta.allure.Step;
import pages.TestCasePage;

public class TestCaseSteps extends BaseSteps {

    TestCasePage testCasePage;

    public TestCaseSteps(TestCasePage testCasePage) {
        this.testCasePage = testCasePage;
    }

    @Step("Verify test case details")
    public void verifyTestCaseDetails(TestCase testCase) {
        testCasePage.isOpened();
        softAssert.assertEquals(testCasePage.getTestCaseTitle(), testCase.getTitle());
        softAssert.assertEquals(testCasePage.getTestCaseSection(), testCase.getSection());
        softAssert.assertEquals(testCasePage.getTestCaseParameter("Type"), testCase.getType());
        softAssert.assertEquals(testCasePage.getTestCaseParameter("Priority"), testCase.getPriority());
        softAssert.assertEquals(testCasePage.getTestCaseParameter("Assigned To"), testCase.getAssignedTo());
        softAssert.assertEquals(testCasePage.getTestCaseParameter("Estimate"), testCase.getEstimate());
        softAssert.assertEquals(testCasePage.getTestCaseParameter("References"), testCase.getReferences());
        softAssert.assertEquals(testCasePage.getTestCaseParameter("Automation Type"), testCase.getAutomationType());
        softAssert.assertEquals(testCasePage.getTestCasePreconditions(), testCase.getPreconditions());
        softAssert.assertEquals(testCasePage.getStepDescription("1"), testCase.getStepDescriptionForFirstStep());
        softAssert.assertEquals(testCasePage.getExpectedResult("1"), testCase.getExpectedResultForFirstStep());
        softAssert.assertEquals(testCasePage.getStepDescription("2"), testCase.getStepDescriptionForSecondStep());
        softAssert.assertEquals(testCasePage.getExpectedResult("2"), testCase.getExpectedResultForSecondStep());
        softAssert.assertAll();
    }

    @Step("Open 'Edit test case' page")
    public void openEditTestCasePage() {
        testCasePage.clickEditButton()
                .isOpened();
    }

    @Step("Open 'Test cases' page from a test case page")
    public void openTestCasesPageFromTestCase() {
        testCasePage.clickSectionName()
                .isOpened();
    }

    @Step("Get test case ID")
    public String getTestCaseId() {
        return testCasePage.getTestCaseId();
    }
}
