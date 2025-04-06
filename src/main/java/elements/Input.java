package elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class Input {
    String label;
    public static final String INPUT_ON_LOGIN_PAGE_LOCATOR = "//*[@data-testid = '%s']";

    public Input(String label) {
        this.label = label;
    }

    public Input writeOnLoginPage(String text) {
        $x(String.format(INPUT_ON_LOGIN_PAGE_LOCATOR, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }
}