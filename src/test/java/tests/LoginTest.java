package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Login on site with correct data in fields")
    public void successLoginTest() {
        loginSteps.checkSuccessfulLogin(EMAIL, PASSWORD);
    }

    @Test(description = "Login on site with empty Email field")
    public void loginWithEmptyEmailTest() {
        loginSteps.checkUnsuccessfulLogin("", PASSWORD)
                .verifyEmailErrorMessage();
    }

    @Test(description = "Login on site with empty Password field")
    public void loginWithEmptyPasswordTest() {
        loginSteps.checkUnsuccessfulLogin(EMAIL, "")
                .verifyPasswordErrorMessage();
    }

    @Test(description = "Login on site with empty Email and Password fields")
    public void loginWithEmptyEmailAndPasswordTest() {
        loginSteps.checkUnsuccessfulLogin("", "")
                .verifyEmailAndPasswordErrorMessage();
    }

    @Test(description = "Login on site with incorrect data for the Email and Password fields")
    public void loginWithIncorrectEmailAndPasswordTest() {
        loginSteps.checkUnsuccessfulLogin("admin", "admin")
                .verifyErrorMessageAboveFields();
    }
}