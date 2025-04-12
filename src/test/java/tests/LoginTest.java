package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Login on site with correct data in fields")
    public void successLoginTest() {
        loginSteps.successfulLogin(EMAIL, PASSWORD);
    }

    @Test(description = "Login on site with empty Email field")
    public void loginWithEmptyEmailTest() {
        loginSteps.unsuccessfulLogin("", PASSWORD)
                .verifyEmailErrorMessage();
    }

    @Test(description = "Login on site with empty Password field")
    public void loginWithEmptyPasswordTest() {
        loginSteps.unsuccessfulLogin(EMAIL, "")
                .verifyPasswordErrorMessage();
    }

    @Test(description = "Login on site with empty Email and Password fields")
    public void loginWithEmptyEmailAndPasswordTest() {
        loginSteps.unsuccessfulLogin("", "")
                .verifyEmailAndPasswordErrorMessage();
    }

    @Test(description = "Login on site with incorrect data for the Email and Password fields")
    public void loginWithIncorrectEmailAndPasswordTest() {
        loginSteps.unsuccessfulLogin("admin", "admin")
                .verifyErrorMessageAboveFields();
    }
}