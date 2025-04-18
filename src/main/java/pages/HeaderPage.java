package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class HeaderPage extends BasePage {
    private static final SelenideElement USER_NAME = $x("//*[@class='navigation-username link-tooltip']");
    private static final SelenideElement LOG_OUT_BUTTON = $(By.id("navigation-user-logout"));

    public HeaderPage() {
    }

    public HeaderPage clickUserName() {
        log.info("Clicking on user name");
        new Button().click(USER_NAME);
        return this;
    }

    public LoginPage clickLogOutButton() {
        log.info("Clicking on 'Log Out' button");
        new Button().click(LOG_OUT_BUTTON);
        return new LoginPage();
    }
}