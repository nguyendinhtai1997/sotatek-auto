package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SettingsTabScreenPage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement settingsTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement walletTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement contactsTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement securityTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement preferenceTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement networkAppearanceTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement walletConnectTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement airdropCodeTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement feedbackTxt;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement addWalletIcon;

    @AndroidFindBys(@AndroidBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView"))
    @iOSXCUITFindBy(id = "")
    private List<MobileElement> settingsWalletIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Back up seed phrase')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement backUpSeedPhraseButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy(id = "")
    private MobileElement checkbox1;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy(id = "")
    private MobileElement checkbox2;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy(id = "")
    private MobileElement checkbox3;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Back up wallet')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement backUpWalletButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Copy 12 phrase')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement copyPhraseTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'copied to somewhere safe')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement iHaveCopiedToSomewhereSafeButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement addContactIcon;

    @AndroidFindBys(@AndroidBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"))
    @iOSXCUITFindBy(id = "")
    private List<MobileElement> listPhrase;

    @AndroidFindBys(@AndroidBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"))
    @iOSXCUITFindBy(id = "")
    private List<MobileElement> list12Phrase;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement deleteIcon;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(id = "")
    private MobileElement inputNameWallet;

    @AndroidFindBys(@AndroidBy(xpath = "//android.widget.EditText"))
    @iOSXCUITFindBy(id = "")
    private List<MobileElement> listInputAddContact;

    @AndroidFindBys(@AndroidBy(xpath = "//android.widget.ImageView"))
    @iOSXCUITFindBy(id = "")
    private List<MobileElement> imageAvatarList;

    @AndroidFindBys(@AndroidBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView"))
    @iOSXCUITFindBy(id = "")
    private List<MobileElement> walletConnectTextList;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(id = "")
    private MobileElement inputAirDropCode;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "")
    private MobileElement titlePopUp;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private List<MobileElement> listTextViewPopUp;

    public SettingsTabScreenPage() {
    }

    public List<String> getListTextFunc() {
        List<String> listTextFunc = new ArrayList<>();
        listTextFunc.add(settingsTxt.getText());
        listTextFunc.add(walletTxt.getText());
        listTextFunc.add(contactsTxt.getText());
        listTextFunc.add(securityTxt.getText());
        listTextFunc.add(preferenceTxt.getText());
        listTextFunc.add(networkAppearanceTxt.getText());
        listTextFunc.add(walletConnectTxt.getText());
        listTextFunc.add(airdropCodeTxt.getText());
        listTextFunc.add(feedbackTxt.getText());
        return listTextFunc;
    }

    public void pressFuncSettingsBtn(String txtBtn) {
        switch (txtBtn) {
            case "Wallet":
                click(walletTxt);
                break;
            case "Contacts":
                click(contactsTxt);
                break;
            case "Security":
                click(securityTxt);
                break;
            case "Network Appearance":
                click(networkAppearanceTxt);
                break;
            case "Preference":
                click(preferenceTxt);
                break;
            case "WalletConnect":
                click(walletConnectTxt);
                break;
            case "Airdrop code":
                click(airdropCodeTxt);
                break;
            case "Feedback":
                click(feedbackTxt);
                break;
            default:
                break;
        }
    }

    public void pressAddWalletIcon() {
        click(addWalletIcon);
    }

    public void pressIconSettingNewWallet() {
        click(settingsWalletIcon.get(settingsWalletIcon.size() - 1));
    }

    public void pressBackUpSeedPhraseButton() {
        click(backUpSeedPhraseButton);
    }

    public void acceptAllCheckbox() {
        click(checkbox1);
        click(checkbox2);
        click(checkbox3);
    }

    public void pressBackUpWallet() {
        click(backUpWalletButton);
    }

    public void pressCopyPhrase() {
        click(copyPhraseTxt);
    }

    public void pressIHaveCopiedToSomewhereSafe() {
        click(iHaveCopiedToSomewhereSafeButton);
    }

    public void pressAddContactIcon() {
        click(addContactIcon);
    }

    public List<String> getAll12Phrase() {
        List<String> phrase = new ArrayList<>();
        phrase.add(list12Phrase.get(1).getText());
        phrase.add(list12Phrase.get(2).getText());
        phrase.add(list12Phrase.get(3).getText());
        phrase.add(list12Phrase.get(4).getText());
        phrase.add(list12Phrase.get(5).getText());
        phrase.add(list12Phrase.get(6).getText());
        phrase.add(list12Phrase.get(7).getText());
        phrase.add(list12Phrase.get(8).getText());
        phrase.add(list12Phrase.get(9).getText());
        phrase.add(list12Phrase.get(10).getText());
        phrase.add(list12Phrase.get(11).getText());
        phrase.add(list12Phrase.get(12).getText());
        return phrase;
    }

    public void pressAllPhrase() {
        for (int i = 0; i < 12; i++) {
            if (getAll12Phrase().get(0).equals(getAllPhrase().get(i))) {
                click(listPhrase.get(i));
                getAll12Phrase().remove(0);
            }
        }
    }

    public List<String> getAllPhrase() {
        List<String> phrase = new ArrayList<>();
        phrase.add(listPhrase.get(1).getText());
        phrase.add(listPhrase.get(2).getText());
        phrase.add(listPhrase.get(3).getText());
        phrase.add(listPhrase.get(4).getText());
        phrase.add(listPhrase.get(5).getText());
        phrase.add(listPhrase.get(6).getText());
        phrase.add(listPhrase.get(7).getText());
        phrase.add(listPhrase.get(8).getText());
        phrase.add(listPhrase.get(9).getText());
        phrase.add(listPhrase.get(10).getText());
        phrase.add(listPhrase.get(11).getText());
        phrase.add(listPhrase.get(12).getText());
        return phrase;
    }

    public void pressDeleteIcon() {
        click(deleteIcon);
    }

    public void clearWalletName() {
        clear(inputNameWallet);
    }

    public void setNewName(String newName) {
        sendKeys(inputNameWallet, newName);
    }

    public void setContact(String contactName, String contactAddress) {
        sendKeys(listInputAddContact.get(0), contactName);
        sendKeys(listInputAddContact.get(1), contactAddress);
    }

    public void pressRandomAvatar() {
        Random rand = new Random();
        click(imageAvatarList.get(rand.nextInt(imageAvatarList.size())));
    }

    public void verifyTextWalletConnectScreen(String title, String content) {
        Assert.assertEquals(walletConnectTextList.get(0).getText(), title);
        Assert.assertEquals(walletConnectTextList.get(1).getText(), content);
    }

    public void inputAirdropCode(String code) {
        sendKeys(inputAirDropCode, code);
    }

    public void inputAirdropCode(String code, String content) {
        Assert.assertEquals(titlePopUp.getText(), code);
        Assert.assertEquals(listTextViewPopUp.get(1).getText(), content);
        click(listTextViewPopUp.get(1));
    }
}
