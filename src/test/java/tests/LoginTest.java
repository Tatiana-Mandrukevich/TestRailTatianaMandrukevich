package tests;

import org.testng.annotations.Test;

import static constants.IConstants.ALL_PROJECTS_URL_UI;
import static constants.IConstants.LOGIN_URL_UI;

public class LoginTest extends BaseTest {

    @Test(description = "Login on site with correct data in fields")
    public void successLoginTest() {
        loginSteps.login(PropertyReader.getProperty("EMAIL"), PropertyReader.getProperty("PASSWORD"));
        allProjectsPage.isOpened();
        softAssert.assertEquals(allProjectsPage.getCurrentUrl(), ALL_PROJECTS_URL_UI);
        softAssert.assertAll();
    }

    @Test(description = "Login on site with empty Email field")
    public void loginWithEmptyEmailTest() {
        loginSteps.login("", PropertyReader.getProperty("PASSWORD"));
        softAssert.assertEquals(loginPage.getCurrentUrl(), LOGIN_URL_UI);
        softAssert.assertEquals(loginPage.getLoginErrorMessageForInput("Email"), loginPage.EMAIL_ERROR_MESSAGE);
        softAssert.assertFalse(loginPage.isErrorMessageForInputFieldPresent("Password"));
        softAssert.assertAll();
    }

    @Test(description = "Login on site with empty Password field")
    public void loginWithEmptyPasswordTest() {
        loginSteps.login(PropertyReader.getProperty("EMAIL"), "");
        softAssert.assertEquals(loginPage.getCurrentUrl(), LOGIN_URL_UI);
        softAssert.assertEquals(loginPage.getLoginErrorMessageForInput("Password"), loginPage.PASSWORD_ERROR_MESSAGE);
        softAssert.assertFalse(loginPage.isErrorMessageForInputFieldPresent("Email"));
        softAssert.assertAll();
    }

    @Test(description = "Login on site with empty Email and Password fields")
    public void loginWithEmptyEmailAndPasswordTest() {
        loginSteps.login("", "");
        softAssert.assertEquals(loginPage.getCurrentUrl(), LOGIN_URL_UI);
        softAssert.assertEquals(loginPage.getLoginErrorMessageForInput("Email"), loginPage.EMAIL_ERROR_MESSAGE);
        softAssert.assertEquals(loginPage.getLoginErrorMessageForInput("Password"), loginPage.PASSWORD_ERROR_MESSAGE);
        softAssert.assertAll();
    }

    @Test(description = "Login on site with incorrect data for the Email and Password fields")
    public void loginWithIncorrectEmailAndPasswordTest() {
        loginSteps.login("admin", "admin");
        softAssert.assertEquals(loginPage.getCurrentUrl(), LOGIN_URL_UI);
        softAssert.assertFalse(loginPage.isErrorMessageForInputFieldPresent("Email"));
        softAssert.assertFalse(loginPage.isErrorMessageForInputFieldPresent("Password"));
        softAssert.assertEquals(loginPage.getLoginErrorMessageAboveInputs("error-on-top"), loginPage.LOGIN_ERROR_ON_TOP);
        softAssert.assertEquals(loginPage.getLoginErrorMessageAboveInputs("error-text"), loginPage.LOGIN_ERROR_TEXT);
        softAssert.assertAll();
    }
}