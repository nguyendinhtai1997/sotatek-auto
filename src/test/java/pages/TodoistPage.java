package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;

public class TodoistPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'CONTINUE WITH EMAIL')]")
    private MobileElement continueWithEmailBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private MobileElement emailInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Password')]")
    private MobileElement passwordInput;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'LOG IN')]")
    private MobileElement loginBtn;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Menu']")
    private MobileElement menuBtn;

    @AndroidFindBys(@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.todoist:id/name']"))
    private List<MobileElement> listProjects;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Quick add']")
    private MobileElement quickAddTaskBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    private MobileElement goalInput;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Add']")
    private MobileElement addBtn;

    @AndroidFindBys(@AndroidBy(xpath = "//android.widget.CheckBox[@content-desc='Complete']"))
    private List<MobileElement> listTasks;

    @AndroidFindBys(@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.todoist:id/text']"))
    private List<MobileElement> listNameTasks;

    public TodoistPage() {
    }

    public void tapContinueWithEmailBtn() {
        click(continueWithEmailBtn);
    }

    public void inputEmail(String email) {
        sendKeys(emailInput, email);
    }

    public void inputPassword(String password) {
        sendKeys(passwordInput, password);
    }

    public void tapLoginBtn() {
        click(loginBtn);
    }

    public void hideKeyboard() {
        hideKeyboardAndroid();
    }

    public void tapMenuBtn() {
        click(menuBtn);
    }

    public String getNameLastProject() {
        return getText(listProjects.get(listProjects.size() - 1), "Name of project: ");
    }

    public void tapQuickAddTaskBtn() {
        click(quickAddTaskBtn);
    }

    public void inputGoal(String goalText) {
        sendKeys(goalInput, goalText);
        click(addBtn);
    }

    public void tapLastProject() {
        click(menuBtn);
        click(listProjects.get(listProjects.size() - 1));
    }

    public void completeLastTask() {
        click(listTasks.get(listTasks.size() - 1));
    }

    public String getNameLastTask() {
        return getText(listNameTasks.get(listNameTasks.size() - 1), "Name of task: ");
    }
}
