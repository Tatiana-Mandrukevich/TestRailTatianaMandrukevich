package elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {
    String label;
    private static final String DROPDOWN_LOCATOR = "//*[@id = '%s']";
    private static final String DROPDOWN_OPTION_LOCATOR = DROPDOWN_LOCATOR + "//*[contains(text(), '%s')]";

    public Dropdown(String label) {
        this.label = label;
    }

    /**
     * This method is used to select an option from a dropdown.
     * @param option - the option to be selected.
     */
    public void selectOptionFromDropdown(String option) {
        $x(String.format(DROPDOWN_LOCATOR, label)).click();
        $x(String.format(DROPDOWN_OPTION_LOCATOR, label, option)).shouldBe(Condition.clickable).click();
    }
}