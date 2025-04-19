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

    public DialogConfirmationPage isOpenedFirstDialogPage() {
        DELETE_PERMANENTLY_BUTTON_ON_FIRST_DIALOG_PAGE.shouldBe(Condition.visible);
        return this;
    }

    public DialogConfirmationPage isOpenedSecondDialogPage() {
        DELETE_PERMANENTLY_BUTTON_ON_SECOND_DIALOG_PAGE.shouldBe(Condition.visible);
        return this;
    }

    public DialogConfirmationPage clickDeletePermanentlyButtonOnFirstDialogPage() {
        log.info("Clicking on 'Delete Permanently' button on the first dialog page");
        new Button().click(DELETE_PERMANENTLY_BUTTON_ON_FIRST_DIALOG_PAGE);
        return this;
    }

    public TestCasesPage clickDeletePermanentlyButtonOnSecondDialogPage() {
        log.info("Clicking on 'Delete Permanently' button on the second dialog page");
        new Button().click(DELETE_PERMANENTLY_BUTTON_ON_SECOND_DIALOG_PAGE);
        return new TestCasesPage();
    }
}