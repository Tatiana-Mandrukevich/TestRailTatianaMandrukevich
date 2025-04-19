package steps;

import io.qameta.allure.Step;
import pages.HeaderPage;
import pages.LoginPage;

public class HeaderSteps extends BaseSteps {

    HeaderPage headerPage;
    LoginPage loginPage;

    public HeaderSteps(HeaderPage headerPage, LoginPage loginPage) {
        this.headerPage = headerPage;
        this.loginPage = loginPage;
    }

    @Step("Log out from the application")
    public void logOut() {
        headerPage.clickUserName()
                .clickLogOutButton()
                .isOpened();
    }
}