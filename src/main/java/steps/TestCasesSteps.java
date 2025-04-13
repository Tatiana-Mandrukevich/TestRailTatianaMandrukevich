package steps;

import adapters.SectionAdapter;
import io.qameta.allure.Step;
import pages.TestCasesPage;

public class TestCasesSteps extends BaseSteps {

    TestCasesPage testCasesPage;
    SectionAdapter sectionAdapter;

    public TestCasesSteps(TestCasesPage testCasesPage, SectionAdapter sectionAdapter) {
        this.testCasesPage = testCasesPage;
        this.sectionAdapter = sectionAdapter;
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
}
