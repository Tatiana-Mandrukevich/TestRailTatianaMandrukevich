package tests;

import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {

    @Test(description = "Log out from the application")
    public void logOutTest() {
        loginSteps.checkSuccessfulLogin(EMAIL, PASSWORD);
        headerSteps.checkLogOut();
    }
}