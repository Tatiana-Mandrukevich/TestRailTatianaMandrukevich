package tests;

import entity.TestCase;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    @Test(description = "Add test case test and verify test case details")
    public void addTestCaseTest() {
        projectSteps.addProject();
        sectionSteps.addSection();
        loginSteps.successfulLogin(EMAIL, PASSWORD);
        testCasesSteps.openTestCasesPage();
        testCasesSteps.openAddTestCasePage();
        TestCase testCase = addTestCaseSteps.addTestCase();
        testCaseSteps.verifyTestCaseDetails(testCase);
    }
}
