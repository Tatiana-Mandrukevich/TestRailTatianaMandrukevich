package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$x;

public class AllProjectsPage extends BasePage {
    private static final String ADD_PROJECT_BUTTON = "//a[contains(text(), 'Add Project') and contains(@class, 'button-add')]";

    public AllProjectsPage isOpened() {
        $x(String.format(ADD_PROJECT_BUTTON)).shouldBe(Condition.visible);
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