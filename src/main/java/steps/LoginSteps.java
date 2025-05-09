package steps;

import io.qameta.allure.Step;
import pages.AllProjectsPage;
import pages.LoginPage;

public class LoginSteps extends BaseSteps {

    LoginPage loginPage;
    AllProjectsPage allProjectsPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
        this.allProjectsPage = new AllProjectsPage();
    }

    @Step("Login by user: {email}")
    public void checkSuccessfulLogin(String email, String password) {
        loginPage
                .openLoginPage()
                .login(email, password)
                        .isOpened();
        softAssert.assertEquals(allProjectsPage.getCurrentUrl(), ALL_PROJECTS_URL_UI);
        softAssert.assertAll();
    }

    @Step("Login by user: {email}")
    public LoginSteps checkUnsuccessfulLogin(String email, String password) {
        loginPage
                .openLoginPage()
                .login(email, password);
        softAssert.assertEquals(loginPage.getCurrentUrl(), LOGIN_URL_UI);
        softAssert.assertAll();
        return this;
    }

    @Step("Verify error message for Email input field")
    public void verifyEmailErrorMessage() {
        softAssert.assertEquals(loginPage.getLoginErrorMessageForInput("Email"), loginPage.getEMAIL_ERROR_MESSAGE());
        softAssert.assertFalse(loginPage.isErrorMessageForInputFieldPresent("Password"));
        softAssert.assertAll();
    }

    @Step("Verify error message for Password input field")
    public void verifyPasswordErrorMessage() {
        softAssert.assertEquals(loginPage.getLoginErrorMessageForInput("Password"), loginPage.getPASSWORD_ERROR_MESSAGE());
        softAssert.assertFalse(loginPage.isErrorMessageForInputFieldPresent("Email"));
        softAssert.assertAll();
    }

    @Step("Verify error message for Email and Password input fields")
    public void verifyEmailAndPasswordErrorMessage() {
        softAssert.assertEquals(loginPage.getLoginErrorMessageForInput("Email"), loginPage.getEMAIL_ERROR_MESSAGE());
        softAssert.assertEquals(loginPage.getLoginErrorMessageForInput("Password"), loginPage.getPASSWORD_ERROR_MESSAGE());
        softAssert.assertAll();
    }

    @Step("Verify error message above input fields")
    public void verifyErrorMessageAboveFields() {
        softAssert.assertFalse(loginPage.isErrorMessageForInputFieldPresent("Email"));
        softAssert.assertFalse(loginPage.isErrorMessageForInputFieldPresent("Password"));
        softAssert.assertEquals(loginPage.getLoginErrorMessageAboveInputs("error-on-top"), loginPage.getLOGIN_ERROR_ON_TOP());
        softAssert.assertEquals(loginPage.getLoginErrorMessageAboveInputs("error-text"), loginPage.getLOGIN_ERROR_TEXT());
        softAssert.assertAll();
    }
}