package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class DialogConfirmationPage extends TestCasesPage {
    private static final SelenideElement DELETE_PERMANENTLY_BUTTON_ON_FIRST_DIALOG_PAGE =
            $x("//*[@data-testid='deleteCaseDialogActionSecondary' and contains(text(), 'Delete Permanently')]");
    private static final SelenideElement DELETE_PERMANENTLY_BUTTON_ON_SECOND_DIALOG_PAGE =
            $x("//*[@data-testid='deleteCaseDialogActionDefault' and contains(text(), 'Delete Permanently')]");


    public DialogConfirmationPage () {
    }

    /**
     * This method is used to check if the first dialog page is opened.
     * @return - the current instance of DialogConfirmationPage.
     */
    public DialogConfirmationPage isOpenedFirstDialogPage() {
        DELETE_PERMANENTLY_BUTTON_ON_FIRST_DIALOG_PAGE.shouldBe(Condition.visible);
        return this;
    }

    /**
     * This method is used to check if the second dialog page is opened.
     * @return - the current instance of DialogConfirmationPage.
     */
    public DialogConfirmationPage isOpenedSecondDialogPage() {
        DELETE_PERMANENTLY_BUTTON_ON_SECOND_DIALOG_PAGE.shouldBe(Condition.visible);
        return this;
    }

    /**
     * This method is used to click on the 'Delete Permanently' button on the first dialog page.
     * @return - the current instance of DialogConfirmationPage.
     */
    public DialogConfirmationPage clickDeletePermanentlyButtonOnFirstDialogPage() {
        log.info("Clicking on 'Delete Permanently' button on the first dialog page");
        new Button().click(DELETE_PERMANENTLY_BUTTON_ON_FIRST_DIALOG_PAGE);
        return this;
    }

    /**
     * This method is used to click on the 'Delete Permanently' button on the second dialog page.
     * @return - the current instance of TestCasesPage.
     */
    public TestCasesPage clickDeletePermanentlyButtonOnSecondDialogPage() {
        log.info("Clicking on 'Delete Permanently' button on the second dialog page");
        new Button().click(DELETE_PERMANENTLY_BUTTON_ON_SECOND_DIALOG_PAGE);
        return new TestCasesPage();
    }
}