package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$x;

public class AllProjectsPage extends BasePage {
    private static final SelenideElement ALL_PROJECTS_TITLE = $x("//div[contains(text(), 'All Project')]");

    public AllProjectsPage isOpened() {
        ALL_PROJECTS_TITLE.shouldBe(Condition.visible);
        return this;
    }

    /**
     * This is getting the current URL.
     * @return - the current URL.
     */
    public String getCurrentUrl() {
        return WebDriverRunner.url();
    }
}