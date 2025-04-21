package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Input {
    String label;
    private static final String INPUT_LOCATOR = "//*[@id = '%s']";
    private static final String INPUT_LOCATOR_FOR_STEPS_IN_TEST_CASE = "//*[@placeholder='%s' and @element-index='%s']";

    public Input(String label) {
        this.label = label;
    }

    /**
     * This method is used to write text into an input field.
     * @param text - the text to be written.
     */
    public Input write(String text) {
        $x(String.format(INPUT_LOCATOR, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    /**
     * This method is used to write text into an input field for steps in a test case.
     * @param elementIndex - the index of the step's element.
     * @param text - the text to be written.
     */
    public Input writeSteps(String elementIndex, String text) {
        $x(String.format(INPUT_LOCATOR_FOR_STEPS_IN_TEST_CASE, label, elementIndex)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    /**
     * This method is used to clear the text in an input field.
     */
    public Input clear() {
        SelenideElement element = $x(String.format(INPUT_LOCATOR, label));
        element.click();
        element.clear();
        return this;
    }

    /**
     * This method is used to clear the text in an input field for steps in a test case.
     * @param elementIndex - the index of the step's element.
     */
    public Input clearSteps(String elementIndex) {
        SelenideElement element = $x(String.format(INPUT_LOCATOR_FOR_STEPS_IN_TEST_CASE, label, elementIndex));
        element.click();
        element.clear();
        return this;
    }
}