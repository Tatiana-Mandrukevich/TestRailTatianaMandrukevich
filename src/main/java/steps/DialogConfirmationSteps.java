package steps;

import io.qameta.allure.Step;
import pages.DialogConfirmationPage;

public class DialogConfirmationSteps extends BaseSteps {

    DialogConfirmationPage dialogConfirmationPage;

    public DialogConfirmationSteps(DialogConfirmationPage dialogConfirmationPage) {
        this.dialogConfirmationPage = dialogConfirmationPage;
    }

    @Step("Click on the 'Delete Permanently' button in the confirmation dialog")
    public void deletePermanentlyTestCase() {
        dialogConfirmationPage.clickDeletePermanentlyButtonOnFirstDialogPage()
                .isOpenedSecondDialogPage()
                .clickDeletePermanentlyButtonOnSecondDialogPage()
                .isOpened();
    }
}