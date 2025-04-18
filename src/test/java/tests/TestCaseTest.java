package tests;

import entity.TestCase;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    @Test(description = "Add test case test and verify test case details")
    public void addTestCaseTest() {
        projectSteps.addProject();
        sectionSteps.addSection();
        loginSteps.successfulLogin(EMAIL, PASSWORD);
        testCasesSteps.openTestCasesPage()
                .openAddTestCasePage();
        TestCase testCase = addTestCaseSteps.addTestCase();
        testCaseSteps.verifyTestCaseDetails(testCase);
    }

    @Test(description = "Update test case test and verify test case details")
    public void updateTestCaseTest() {
        projectSteps.addProject();
        sectionSteps.addSection();
        loginSteps.successfulLogin(EMAIL, PASSWORD);
        testCasesSteps.openTestCasesPage()
                .openAddTestCasePage();
        TestCase testCase = addTestCaseSteps.addTestCase();
        testCaseSteps.verifyTestCaseDetails(testCase)
                .openEditTestCasePage();
        TestCase updatedTestCase = addTestCaseSteps.updateTestCase();
        testCaseSteps.verifyTestCaseDetails(updatedTestCase);
    }

    @Test(description = "Delete test case test and verify deletion")
    public void deleteTestCaseTest() {
        projectSteps.addProject();
        sectionSteps.addSection();
        loginSteps.successfulLogin(EMAIL, PASSWORD);
        testCasesSteps.openTestCasesPage()
                .openAddTestCasePage();
        addTestCaseSteps.addTestCase();
        String testCaseId = testCaseSteps.getTestCaseId();
        testCaseSteps.openTestCasesPageFromTestCase();
        testCasesSteps.selectTestCaseCheckbox(testCaseId)
                .clickDeleteTestCaseButton();
        dialogConfirmationSteps.deletePermanentlyTestCase();
        testCasesSteps.clickDisplayDeletedTestCasesButton()
                .verifyTestCaseDeletion(testCaseId);
    }
}