package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BeforeMainScreenPage;
import pages.ReceiveScreenPage;
import pages.WalletTabScreenPage;

public class ReceiveScreenStepDef {

    WalletTabScreenPage walletTabScreenPage = new WalletTabScreenPage();
    BeforeMainScreenPage beforeMainScreenPage = new BeforeMainScreenPage();
    ReceiveScreenPage receiveScreenPage = new ReceiveScreenPage();

    @And("user press token {string} network {string}")
    public void user_press_token(String txtToken, String network) {
        walletTabScreenPage.pressTokenTxt(txtToken, network);
    }

    @And("user press button {string} to copy address")
    public void user_press_button_to_copy_address(String btnTxt) {
        beforeMainScreenPage.pressBtn(btnTxt);
    }

    @And("user press button {string} to share address")
    public void user_press_button_to_share_address(String btnTxt) {
        beforeMainScreenPage.pressBtn(btnTxt);
    }

    @Then("verify receive title displayed {string}")
    public void verify_receive_title(String title) {
        Assert.assertEquals(receiveScreenPage.getReceiveTitle(), title.replace("Receive", "Receive "));
    }

    @Then("verify address displayed {string}")
    public void verify_address(String address) {
        Assert.assertEquals(receiveScreenPage.getAddress(), address);
    }

    @Then("verify guide text displayed {string} of {string} {string}")
    public void verify_guide_text(String guideText, String token, String network) {
        Assert.assertEquals(receiveScreenPage.getGuideText(), guideText.replace("Only send ","Only send " + token + " (" + network + ") ").replace("to this address.","to this address.\n"));
    }
}