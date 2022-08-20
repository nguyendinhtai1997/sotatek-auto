package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.ArrayList;
import java.util.List;

public class WalletTabScreenPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement greetingTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement totalWalletValueTxt;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement totalWalletValue;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "")
    private MobileElement sendTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "")
    private MobileElement receiveTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "")
    private MobileElement buyTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "")
    private MobileElement swapTxt;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement tokensTxt;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement NFTsTxt;

    @AndroidFindBy(xpath = "//android.widget.Button[1]/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "")
    private MobileElement walletTabTxt;

    @AndroidFindBy(xpath = "//android.widget.Button[2]/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "")
    private MobileElement browserTabTxt;

    @AndroidFindBy(xpath = "//android.widget.Button[3]/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "")
    private MobileElement settingsTabTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'BHO Network')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement BHOToken;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'BNB Main Network')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement BNBToken;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Binance-Peg BUSD')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement BUSDToken;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Polygon Main Network')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement MaticToken;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Tether USD')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement USDTToken;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Ethereum Main Network')]")
    @iOSXCUITFindBy(id = "")
    private MobileElement ETHToken;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.EditText")
    @iOSXCUITFindBy(id = "")
    private MobileElement receiveWalletAddressInput;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.EditText")
    @iOSXCUITFindBy(id = "")
    private MobileElement amountInput;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.EditText")
    @iOSXCUITFindBy(id = "")
    private MobileElement memoInput;

    public WalletTabScreenPage() {
    }

    public String getGreetingTxt() {
        return getText(greetingTxt, "greeting text is - ");
    }

    public String getTotalWalletValueTxt() {
        return getText(totalWalletValueTxt, "text is - ");
    }

    public String getTotalWalletValue() {
        return getText(totalWalletValue, "value is - ");
    }

    public List<String> getListTextFunc() {
        List<String> listTextFunc = new ArrayList<>();
        listTextFunc.add(sendTxt.getText());
        listTextFunc.add(receiveTxt.getText());
        listTextFunc.add(buyTxt.getText());
        listTextFunc.add(swapTxt.getText());
        return listTextFunc;
    }

    public List<String> getListTextTab() {
        List<String> listTextTab = new ArrayList<>();
        listTextTab.add(tokensTxt.getText());
        listTextTab.add(NFTsTxt.getText());
        return listTextTab;
    }

    public List<String> getListTab() {
        List<String> listTab = new ArrayList<>();
        listTab.add(walletTabTxt.getText());
        listTab.add(browserTabTxt.getText());
        listTab.add(settingsTabTxt.getText());
        return listTab;
    }

    public void pressFuncBtn(String txtBtn) {
        switch (txtBtn) {
            case "Send":
                click(sendTxt);
                break;
            case "Receive":
                click(receiveTxt);
                break;
            case "Buy":
                click(buyTxt);
                break;
            case "Swap":
                click(swapTxt);
                break;
            default:
                break;
        }
    }

    public void pressTokenTxt(String txtToken, String network) {
        if (network.equals("BEP20")){
            switch (txtToken) {
                case "BHO":
                    click(BHOToken);
                    break;
                case "BNB":
                    click(BNBToken);
                    break;
                case "BUSD":
                    click(BUSDToken);
                    break;
                default:
                    break;
            }
        }
        if (network.equals("ERC20")){
            switch (txtToken) {
                case "MATIC":
                    click(MaticToken);
                    break;
                case "USDT":
                    click(USDTToken);
                    break;
                case "ETH":
                    click(ETHToken);
                    break;
                default:
                    break;
            }
        }
    }

    public void enterReceiveAddressWallet(String receiveWalletAddress) {
        sendKeys(receiveWalletAddressInput, receiveWalletAddress);
    }

    public void enterAmount(String amount) {
        sendKeys(amountInput, amount);
    }

    public void enterMemo(String memo) {
        sendKeys(memoInput, memo);
    }

}
