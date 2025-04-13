package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import elements.Button;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPage extends BasePage {
    private static final SelenideElement LOG_IN_BUTTON = $x("//*[@data-testid = 'loginButtonPrimary']");
    private static final String LOGIN_ERROR_MESSAGE_FOR_INPUT = "//div[contains(@class, 'loginpage-message') and contains(text(), '%s')]";
    public static final String EMAIL_ERROR_MESSAGE = "Email/Login is required.";
    public static final String PASSWORD_ERROR_MESSAGE = "Password is required.";
    public static final String LOGIN_ERROR_ON_TOP = "Sorry, there was a problem.";
    public static final String LOGIN_ERROR_TEXT = "Email/Login or Password is incorrect. Please try again.";

    public LoginPage() {
    }

    public LoginPage openLoginPage() {
        log.info("Opening login page");
        open(LOGIN_URL_UI);
        return this;
    }

    public LoginPage isOpened() {
        LOG_IN_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    private LoginPage fillLoginForm(String email, String password) {
        isOpened();
        new Input("name").write(email);
        log.info("Login with data: Email/Login is {}", email);
        new Input("password").write(password);
        new Button().click(LOG_IN_BUTTON);
        return this;
    }

    public AllProjectsPage login(String email, String password) {
        fillLoginForm(email, password);
        return new AllProjectsPage();
    }

    public String getLoginErrorMessageForInput(String inputField) {
        try {
            log.info("Getting Login Error Message For Input");
            return $x(String.format(LOGIN_ERROR_MESSAGE_FOR_INPUT, inputField)).shouldBe(Condition.visible).getText();
        } catch (Exception e) {
            log.error("Failed to get Login Error Message For Input", e);
            return "";
        }
    }

    public boolean isErrorMessageForInputFieldPresent(String inputField) {
        log.info("Checking if error message for input field is present");
        return $x(String.format(LOGIN_ERROR_MESSAGE_FOR_INPUT, inputField)).exists();
    }

    /**
     * This is getting the current URL.
     * @return - the current URL.
     */
    public String getCurrentUrl() {
        log.info("Getting current URL");
        return WebDriverRunner.url();
    }

    public String getLoginErrorMessageAboveInputs(String errorClassName) {
        try {
            log.info("Getting Login Error Message Above Inputs");
            return $(By.className(errorClassName)).shouldBe(Condition.visible).getText();
        } catch (Exception e) {
            log.error("Failed to get Login Error Message Above Inputs", e);
            return "";
        }
    }
}