package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BeforeMainScreenPage;
import pages.SettingsTabScreenPage;

import java.util.ArrayList;
import java.util.List;

public class SettingsTabScreenStepDef {

    SettingsTabScreenPage settingsTabScreenPage = new SettingsTabScreenPage();
    BeforeMainScreenPage beforeMainScreenPage = new BeforeMainScreenPage();

    @Then("verify all text displayed on Settings Tab")
    public void verify_all_text_displayed_on_settings_tab() {
        List<String> listTextFunc = new ArrayList<>();
        listTextFunc.add("Settings");
        listTextFunc.add("Wallet");
        listTextFunc.add("Contacts");
        listTextFunc.add("Security");
        listTextFunc.add("Preference");
        listTextFunc.add("Network Appearance");
        listTextFunc.add("WalletConnect");
        listTextFunc.add("Airdrop code");
        listTextFunc.add("Feedback");
        Assert.assertEquals(listTextFunc, settingsTabScreenPage.getListTextFunc());
    }

    @And("user press settings function button {string}")
    public void user_press_function_button(String btnTxt) {
        settingsTabScreenPage.pressFuncSettingsBtn(btnTxt);
    }

    @And("user add new wallet")
    public void userAddNewWallet() {
        settingsTabScreenPage.pressAddWalletIcon();
    }

    @And("user press icon setting new wallet")
    public void userPressIconSettingNewWallet() {
        settingsTabScreenPage.pressIconSettingNewWallet();
    }

    @And("user press back up seed phrase")
    public void userPressBackUpSeedPhrase() {
        settingsTabScreenPage.pressBackUpSeedPhraseButton();
    }

    @And("user accept all checkbox")
    public void userAcceptAllCheckbox() {
        settingsTabScreenPage.acceptAllCheckbox();
    }

    @And("user press back up wallet")
    public void userPressBackUpWallet() {
        settingsTabScreenPage.pressBackUpWallet();
    }

    @And("user press I have copied to somewhere safe")
    public void userPressIHaveCopiedToSomewhereSafe() {
        settingsTabScreenPage.pressIHaveCopiedToSomewhereSafe();

    }

    @And("user double check phrase")
    public void userDoubleCheckPhrase() {
        settingsTabScreenPage.pressAllPhrase();

    }

    @And("user delete wallet")
    public void userDeleteWallet() {
        beforeMainScreenPage.pressBtn("Settings");
        beforeMainScreenPage.pressBtn("Wallet");
        settingsTabScreenPage.pressIconSettingNewWallet();
        beforeMainScreenPage.pressBtn("Done");
    }

    @And("user input seed phrase and wallet name")
    public void userInputSeedPhraseAndWalletName() {
        String seedPhrase = String.join(" ", settingsTabScreenPage.getAll12Phrase());
        beforeMainScreenPage.enterSeedPhrase(seedPhrase);
        beforeMainScreenPage.enterWalletName("Auto Test 22");
    }

    @And("user clear name wallet")
    public void userClearNameWallet() {
        settingsTabScreenPage.clearWalletName();
    }

    @And("user input new name {string}")
    public void userInputNewName(String newName) {
        settingsTabScreenPage.setNewName(newName);
    }

    @And("user press add contact")
    public void userPressAddContact() {
        settingsTabScreenPage.pressAddContactIcon();
    }

    @And("user input {string} and {string}")
    public void userInputContactNameContactAddress(String contactName, String contactAddress) {
        settingsTabScreenPage.setContact(contactName, contactAddress);
    }

    @And("user choose random image")
    public void userChooseRandomImage() {
        settingsTabScreenPage.pressRandomAvatar();
    }

    @And("user verify text on WalletConnect screen with title {string} and content {string}")
    public void userVerifyTextOnWalletConnectScreenWithTitleAndContent(String title, String content) {
        settingsTabScreenPage.verifyTextWalletConnectScreen(title, content);
    }

    @And("user input airdrop code {string}")
    public void userInputAirdropCode(String code) {
        settingsTabScreenPage.inputAirdropCode(code);
    }

    @Then("user verify popup title {string} content {string}")
    public void userVerifyPopupTitleContent(String title, String content) {
        settingsTabScreenPage.inputAirdropCode(title, content);
    }
}
