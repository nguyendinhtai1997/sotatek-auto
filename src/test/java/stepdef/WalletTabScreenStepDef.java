package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.WalletTabScreenPage;

import java.util.ArrayList;
import java.util.List;

public class WalletTabScreenStepDef {

    WalletTabScreenPage walletTabScreenPage = new WalletTabScreenPage();

    @Then("verify greeting displayed")
    public void verify_greeting() {
        Integer hour = java.time.LocalTime.now().getHour();
        List<Integer> morningTimeList = new ArrayList<>();
        List<Integer> noonTimeList = new ArrayList<>();
        List<Integer> afternoonTimeList = new ArrayList<>();
        List<Integer> nightTimeList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            nightTimeList.add(i);
        }
        for (int i = 4; i < 11; i++) {
            morningTimeList.add(i);
        }
        for (int i = 11; i < 14; i++) {
            noonTimeList.add(i);
        }
        for (int i = 14; i < 18; i++) {
            afternoonTimeList.add(i);
        }
        for (int i = 18; i < 24; i++) {
            nightTimeList.add(i);
        }
        if (morningTimeList.contains(hour)) {
            Assert.assertEquals(walletTabScreenPage.getGreetingTxt(), "Good morning");
        }
        if (noonTimeList.contains(hour)) {
            Assert.assertEquals(walletTabScreenPage.getGreetingTxt(), "Good afternoon");
        }
        if (afternoonTimeList.contains(hour)) {
            Assert.assertEquals(walletTabScreenPage.getGreetingTxt(), "Good afternoon");
        }
        if (nightTimeList.contains(hour)) {
            Assert.assertEquals(walletTabScreenPage.getGreetingTxt(), "Good night");
        }
    }

    @Then("verify all text displayed on Wallet Tab")
    public void verify_all_text_displayed_on_wallet_tab() {
        Assert.assertEquals(walletTabScreenPage.getTotalWalletValueTxt(), "Total wallet value");
//        Assert.assertEquals(walletTabScreenPage.getTotalWalletValue(), "$0");
        List<String> listTextFunc = new ArrayList<>();
        listTextFunc.add("Send");
        listTextFunc.add("Receive");
        listTextFunc.add("Buy");
        listTextFunc.add("Swap");
        Assert.assertEquals(walletTabScreenPage.getListTextFunc(), listTextFunc);
        List<String> listTextTab = new ArrayList<>();
        listTextTab.add("Tokens");
        listTextTab.add("NFTs");
        Assert.assertEquals(walletTabScreenPage.getListTextTab(), listTextTab);
        List<String> listTab = new ArrayList<>();
        listTab.add("Wallet");
        listTab.add("Browser");
        listTab.add("Settings");
        Assert.assertEquals(walletTabScreenPage.getListTab(), listTab);
    }

    @And("user press function button {string}")
    public void user_press_function_button(String btnTxt) {
        walletTabScreenPage.pressFuncBtn(btnTxt);
    }

    @And("user press back")
    public void user_press_back() throws InterruptedException {
        Thread.sleep(2000);
        walletTabScreenPage.backAndroid();
        Thread.sleep(2000);
    }

    @And("user enter receive address wallet {string}")
    public void user_enter_receive_address_wallet(String receiveAddressWallet) {
        walletTabScreenPage.enterReceiveAddressWallet(receiveAddressWallet);
    }

    @And("user enter amount {string}")
    public void user_enter_amount(String amount) {
        walletTabScreenPage.enterAmount(amount);
    }

    @And("user enter memo {string}")
    public void user_enter_memo(String memo) {
        walletTabScreenPage.enterMemo(memo);
    }
}
