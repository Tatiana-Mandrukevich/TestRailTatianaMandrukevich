package steps;

import adapters.SectionAdapter;
import io.qameta.allure.Step;
import pages.TestCasePage;
import pages.TestCasesPage;

public class TestCasesSteps extends BaseSteps {

    TestCasesPage testCasesPage;
    SectionAdapter sectionAdapter;
    TestCasePage testCasePage;

    public TestCasesSteps(TestCasesPage testCasesPage, SectionAdapter sectionAdapter, TestCasePage testCasePage) {
        this.testCasesPage = testCasesPage;
        this.sectionAdapter = sectionAdapter;
        this.testCasePage = testCasePage;
    }

    @Step("Open test cases page")
    public void openTestCasesPage() {
        testCasesPage.openTestCasesPage(sectionAdapter.getCreatedSectionSuiteId())
                .isOpened();
    }

    @Step("Open 'Add test case' page")
    public void openAddTestCasePage() {
        testCasesPage.clickAddCaseButton()
                .isOpened();
    }

    @Step("Select checkbox for a test case")
    public void selectTestCaseCheckbox(String testCaseId) {
        testCasesPage.selectTestCaseCheckbox(testCaseId);
    }

    @Step("Click on 'Delete' button for test case")
    public void clickDeleteTestCaseButton() {
        testCasesPage.clickDeleteButton()
                .isOpenedFirstDialogPage();
    }
}
