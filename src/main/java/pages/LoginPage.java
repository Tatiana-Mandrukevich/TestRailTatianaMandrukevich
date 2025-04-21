package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import elements.Button;
import elements.Input;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
@Getter
public class LoginPage extends BasePage {
    private static final SelenideElement LOG_IN_BUTTON = $x("//*[@data-testid = 'loginButtonPrimary']");
    private static final String LOGIN_ERROR_MESSAGE_FOR_INPUT = "//div[contains(@class, 'loginpage-message') and contains(text(), '%s')]";
    private final String EMAIL_ERROR_MESSAGE = "Email/Login is required.";
    private final String PASSWORD_ERROR_MESSAGE = "Password is required.";
    private final String LOGIN_ERROR_ON_TOP = "Sorry, there was a problem.";
    private final String LOGIN_ERROR_TEXT = "Email/Login or Password is incorrect. Please try again.";

    public LoginPage() {
    }

    /**
     * This method is used to open the login page.
     * @return - the current instance of LoginPage.
     */
    public LoginPage openLoginPage() {
        log.info("Opening login page");
        open(LOGIN_URL_UI);
        return this;
    }

    /**
     * This method is used to check if the login page is opened.
     * @return - the current instance of LoginPage.
     */
    public LoginPage isOpened() {
        LOG_IN_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    /**
     * This method is used to fill the login form.
     * @param email - email or login.
     * @param password - password.
     * @return - the current instance of LoginPage.
     */
    private LoginPage fillLoginForm(String email, String password) {
        isOpened();
        new Input("name").write(email);
        log.info("Login with data: Email/Login is {}", email);
        new Input("password").write(password);
        new Button().click(LOG_IN_BUTTON);
        return this;
    }

    /**
     * This method is used to login.
     * @param email - email or login.
     * @param password - password.
     * @return - AllProjectsPage instance.
     */
    public AllProjectsPage login(String email, String password) {
        fillLoginForm(email, password);
        return new AllProjectsPage();
    }

    /**
     * This method is used to get the error message text.
     * @return - the error message text.
     */
    public String getLoginErrorMessageForInput(String inputField) {
        try {
            log.info("Getting Login Error Message For Input");
            return $x(String.format(LOGIN_ERROR_MESSAGE_FOR_INPUT, inputField)).shouldBe(Condition.visible).getText();
        } catch (Exception e) {
            log.error("Failed to get Login Error Message For Input", e);
            return "";
        }
    }

    /**
     * This method is used to check if the error message for the input field is present.
     * @param inputField - the input field name.
     * @return - true if the error message is present, false otherwise.
     */
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

    /**
     * This method is used to get the login error message above inputs.
     * @param errorClassName - the class name of the error message element.
     * @return - the login error message.
     */
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