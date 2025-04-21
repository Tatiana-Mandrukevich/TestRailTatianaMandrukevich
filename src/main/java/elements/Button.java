package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class Button {

    public Button() {
    }

    /**
     * This method is used to click on a button.
     * @param selenideElement - button to be clicked.
     */
    public void click(SelenideElement selenideElement) {
        selenideElement.shouldBe(Condition.visible).click();
    }
}