package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class BeforeMainScreenPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Get start')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement getStartBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'OK')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement okTxt;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement titleTxt;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement contentTxt;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement inputTxt;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement numInput;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement activeBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement alertTxt;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement popupTitleTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement errorPopupTitleTxt;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement contentErrorPopupTxt;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private MobileElement btnErrorPopupTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Done')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement doneBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Create new 3S wallet')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement createNewWalletBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Continue')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement continueBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'\uE938')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement checkBoxTC;

    @AndroidFindBy(xpath = "//android.widget.Button[3]/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "")
    private MobileElement settingsTabTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement sendBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Cancel')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement cancelBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Copy')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement copyBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Share')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement shareBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'View')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement viewBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Add')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement addBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Appearance')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement appearanceTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Dark Yellow')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement darkYellowTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Account Indenticon')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement accountIndenticonTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'App Language')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement appLanguageTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'English')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement ENTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Tiếng Việt')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement VITxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'New connection')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement newConnectionTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Close')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement closeBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Light Pink')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement lightPinkTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'0')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement btn0;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'1')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement btn1;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'2')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement btn2;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'3')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement btn3;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'4')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement btn4;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'5')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement btn5;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'6')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement btn6;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'7')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement btn7;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'8')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement btn8;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'9')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement btn9;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'I already have a wallet')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement alreadyHaveAWalletBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Import Wallet')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement importWalletBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Finish')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement finishBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")
    @iOSXCUITFindBy(id = "")
    private MobileElement seedPhraseInput;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.EditText")
    @iOSXCUITFindBy(id = "")
    private MobileElement walletNameInput;

    public BeforeMainScreenPage() {
    }

    public String getTitle() {
        return getText(titleTxt, "title text is - ");
    }

    public String getContent() {
        return getText(contentTxt, "content text is - ");
    }

    public String getTextInput() {
        return getText(inputTxt, "text input text is - ");
    }

    public String getNumInput() {
        return getText(numInput, "num input text is - ");
    }

    public String getTextBtn() {
        return getText(activeBtn, "btn input text is - ");
    }

    public void pressInput() {
        click(inputTxt);
    }

    public String getAlertTxt() {
        return getText(alertTxt, "alert text is - ");
    }

    public void inputActivationCode(String activationCode) {
        sendKeys(inputTxt, activationCode);
    }

    public String getPopupTitleTxt() {
        return getText(popupTitleTxt, "popup title text is - ");
    }

    public String getErrorPopupTitleTxt() {
        return getText(errorPopupTitleTxt, "error popup title text is - ");
    }

    public String getContentErrorPopupTxt() {
        return getText(contentErrorPopupTxt, "content error popup text is - ");
    }

    public String getBtnErrorPopupTxt() {
        return getText(btnErrorPopupTxt, "btn error popup text is - ");
    }


    public void pressBtn(String txtBtn) {
        switch (txtBtn) {
            case "Get start":
                click(getStartBtn);
                break;
            case "Done":
                click(doneBtn);
                break;
            case "Active":
                click(activeBtn);
                break;
            case "Create new 3S wallet":
                click(createNewWalletBtn);
                break;
            case "Continue":
                click(continueBtn);
                break;
            case "I already have a wallet":
                click(alreadyHaveAWalletBtn);
                break;
            case "Import Wallet":
                click(importWalletBtn);
                break;
            case "Finish":
                click(finishBtn);
                break;
            case "Settings":
                click(settingsTabTxt);
                break;
            case "Send":
                click(sendBtn);
                break;
            case "Cancel":
                click(cancelBtn);
                break;
            case "Copy":
                click(copyBtn);
                break;
            case "Share":
                click(shareBtn);
                break;
            case "View":
                click(viewBtn);
                break;
            case "Add":
                click(addBtn);
                break;
            case "Appearance":
                click(appearanceTxt);
                break;
            case "Light Pink":
                click(lightPinkTxt);
                break;
            case "Dark Yellow":
                click(darkYellowTxt);
                break;
            case "Account Indenticon":
                click(accountIndenticonTxt);
                break;
            case "App Language":
                click(appLanguageTxt);
                break;
            case "English":
                click(ENTxt);
                break;
            case "Tiếng Việt":
                click(VITxt);
                break;
            case "New connection":
                click(newConnectionTxt);
                break;
            case "Close":
                click(closeBtn);
                break;
            case "OK":
                click(okTxt);
                break;
            case "0":
                click(btn0);
                break;
            case "1":
                click(btn1);
                break;
            case "2":
                click(btn2);
                break;
            case "3":
                click(btn3);
                break;
            case "4":
                click(btn4);
                break;
            case "5":
                click(btn5);
                break;
            case "6":
                click(btn6);
                break;
            case "7":
                click(btn7);
                break;
            case "8":
                click(btn8);
                break;
            case "9":
                click(btn9);
                break;
            default:
                break;
        }
    }

    public void tapCheckbox() {
        click(checkBoxTC);
    }


    public void enterSeedPhrase(String seedPhrase) {
        sendKeys(seedPhraseInput, seedPhrase);
    }

    public void enterWalletName(String walletName) {
        sendKeys(walletNameInput, walletName);
    }
}
