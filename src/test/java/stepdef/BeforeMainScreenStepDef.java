package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BeforeMainScreenPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeforeMainScreenStepDef {

    BeforeMainScreenPage beforeMainScreenPage = new BeforeMainScreenPage();

    @Given("user launch app")
    public void user_launch_app() {
        beforeMainScreenPage.launchApp();
    }

    @And("user press button {string}")
    public void user_press_button(String btnTxt) {
        beforeMainScreenPage.pressBtn(btnTxt);
    }

    @And("user tap checkbox to agree TC")
    public void user_tap_checkbox() throws InterruptedException {
        beforeMainScreenPage.tapCheckbox();
        Thread.sleep(3000);
    }

    @Then("verify title displayed {string}")
    public void verify_title(String title) {
        Assert.assertEquals(beforeMainScreenPage.getTitle(), title);
    }

    @Then("verify content displayed {string}")
    public void verify_content(String content) {
        Assert.assertEquals(beforeMainScreenPage.getContent(), content);
    }

    @Then("verify text input displayed {string}")
    public void verify_text_input(String textInput) {
        Assert.assertEquals(beforeMainScreenPage.getTextInput(), textInput);
    }

    @Then("verify number of characters can input displayed {string}")
    public void verify_num_input(String numInput) {
        Assert.assertEquals(beforeMainScreenPage.getNumInput(), numInput);
    }

    @Then("verify text button displayed {string}")
    public void verify_text_btn(String textBtn) {
        Assert.assertEquals(beforeMainScreenPage.getTextBtn(), textBtn);
    }

    @And("press input")
    public void press_input() {
        beforeMainScreenPage.pressInput();
    }

    @And("user input activation code {string} and active")
    public void user_input_activation_code_and_active(String activationCode) {
        beforeMainScreenPage.inputActivationCode(activationCode);
        beforeMainScreenPage.pressBtn("Active");
    }

    @Then("verify alert text {string} displayed with case {string} use {string} or popup title text display {string}")
    public void verify_alert_text(String alertTxt, String testCase, String activationCode, String popupTitleTxt) throws InterruptedException {
        switch (testCase) {
            case "Active code don't fill":
                beforeMainScreenPage.pressInput();
                Assert.assertEquals(beforeMainScreenPage.getAlertTxt(), alertTxt);
                break;
            case "Active Code is wrong":
                beforeMainScreenPage.inputActivationCode(activationCode);
                beforeMainScreenPage.pressBtn("Active");
                Assert.assertEquals(beforeMainScreenPage.getAlertTxt(), alertTxt);
                break;
            case "Active Code is right":
                beforeMainScreenPage.inputActivationCode(activationCode);
                beforeMainScreenPage.pressBtn("Active");
                Thread.sleep(6000);
                beforeMainScreenPage.backAndroid();
                Assert.assertEquals(beforeMainScreenPage.getPopupTitleTxt(), popupTitleTxt);
                break;
            default:
                break;
        }

    }

    @And("user enter passcode {string}")
    public void user_enter_passcode(String passCode) throws InterruptedException {
        Thread.sleep(10000);
        List<String> listNum = new ArrayList<>(Arrays.asList(passCode.split("")));
        for (String num : listNum) {
            beforeMainScreenPage.pressBtn(num);
        }
    }

    @And("user enter seed phrase {string}")
    public void user_enter_seed_phrase(String seedPhrase) {
        beforeMainScreenPage.enterSeedPhrase(seedPhrase);
    }

    @And("user enter wallet name {string}")
    public void user_enter_wallet_name(String walletName) {
        beforeMainScreenPage.enterWalletName(walletName);
    }

    @Then("verify all text displayed in error popup {string} {string} {string}")
    public void verifyAllTextDisplayedInErrorPopup(String title, String content, String textBtn) throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertEquals(beforeMainScreenPage.getErrorPopupTitleTxt(), title);
        Assert.assertEquals(beforeMainScreenPage.getContentErrorPopupTxt(), content);
        Assert.assertEquals(beforeMainScreenPage.getBtnErrorPopupTxt(), textBtn);
    }
}
