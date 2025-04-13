package elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class Input {
    String label;
    public static final String INPUT_LOCATOR = "//*[@id = '%s']";
    public static final String INPUT_LOCATOR_FOR_STEPS_IN_TEST_CASE = "//*[@placeholder='%s' and @element-index='%s']";

    public Input(String label) {
        this.label = label;
    }

    public Input write(String text) {
        $x(String.format(INPUT_LOCATOR, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeSteps(String elementIndex, String text) {
        $x(String.format(INPUT_LOCATOR_FOR_STEPS_IN_TEST_CASE, label, elementIndex)).shouldBe(Condition.visible).setValue(text);
        return this;
    }
}