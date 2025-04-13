package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class TestCasesPage extends BasePage {
    private static final SelenideElement ADD_CASE_BUTTON = $x("//span[@data-testid = 'suiteAddCaseLink']");

    public TestCasesPage () {
    }

    public TestCasesPage openTestCasesPage(int suiteId) {
        log.info("Opening test cases page");
        open(String.format(TEST_CASES_URL_UI, suiteId));
        return this;
    }

    public TestCasesPage isOpened() {
        ADD_CASE_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public AddTestCasePage clickAddCaseButton() {
        log.info("Clicking on 'Add Case' button");
        new Button().click(ADD_CASE_BUTTON);
        return new AddTestCasePage();
    }
}
