package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class ReceiveScreenPage extends BasePage {

    @AndroidFindAll(@AndroidBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView"))
    @iOSXCUITFindBy(id = "")
    List<MobileElement> receiveTitle;

    public ReceiveScreenPage() {
    }

    public String getReceiveTitle() {
        return getText(receiveTitle.get(0), "receive title text is - ");
    }

    public String getAddress() {
        return getText(receiveTitle.get(1), "Address is - ");
    }

    public String getGuideText() {
        return getText(receiveTitle.get(2), "Guide is - ");
    }
}
