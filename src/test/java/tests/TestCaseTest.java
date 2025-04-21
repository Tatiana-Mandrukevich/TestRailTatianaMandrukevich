package tests;

import entity.TestCase;
import org.testng.annotations.Test;
import tests.utils.Retry;

public class TestCaseTest extends BaseTest {

    @Test(description = "Add test case test and verify test case details", retryAnalyzer = Retry.class)
    public void addTestCaseTest() {
        projectSteps.addProject(Preconditions.projectWithDefaultValues);
        sectionSteps.addSection(Preconditions.sectionWithDefaultValues);
        loginSteps.checkSuccessfulLogin(EMAIL, PASSWORD);
        testCasesSteps.openTestCasesPage()
                .openAddTestCasePage();
        TestCase testCase = addTestCaseSteps.addTestCase(preconditions.getTestCaseWithDefaultValues());
        testCaseSteps.verifyTestCaseDetails(testCase);
    }

    @Test(description = "Update test case test and verify test case details", retryAnalyzer = Retry.class)
    public void updateTestCaseTest() {
        projectSteps.addProject(Preconditions.projectWithDefaultValues);
        sectionSteps.addSection(Preconditions.sectionWithDefaultValues);
        loginSteps.checkSuccessfulLogin(EMAIL, PASSWORD);
        testCasesSteps.openTestCasesPage()
                .openAddTestCasePage();
        TestCase testCase = addTestCaseSteps.addTestCase(preconditions.getTestCaseWithDefaultValues());
        testCaseSteps.verifyTestCaseDetails(testCase)
                .openEditTestCasePage();
        TestCase updatedTestCase = addTestCaseSteps.updateTestCase(preconditions.getTestCaseWithUpdatedValues());
        testCaseSteps.verifyTestCaseDetails(updatedTestCase);
    }

    @Test(description = "Delete test case test and verify deletion", retryAnalyzer = Retry.class)
    public void deleteTestCaseTest() {
        projectSteps.addProject(Preconditions.projectWithDefaultValues);
        sectionSteps.addSection(Preconditions.sectionWithDefaultValues);
        loginSteps.checkSuccessfulLogin(EMAIL, PASSWORD);
        testCasesSteps.openTestCasesPage()
                .openAddTestCasePage();
        addTestCaseSteps.addTestCase(preconditions.getTestCaseWithDefaultValues());
        String testCaseId = testCaseSteps.getTestCaseId();
        testCaseSteps.openTestCasesPageFromTestCase();
        testCasesSteps.selectTestCaseCheckbox(testCaseId)
                .clickDeleteTestCaseButton();
        dialogConfirmationSteps.deletePermanentlyTestCase();
        testCasesSteps.clickDisplayDeletedTestCasesButton()
                .verifyTestCaseDeletion(testCaseId);
    }
}