package stepdef;

import com.google.gson.reflect.TypeToken;
import common.handlers.Common;
import common.handlers.RequestAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import pages.TodoistPage;
import todoist.models.request.CreateProjectRequest;
import todoist.models.response.CreateProjectResponse;
import todoist.models.response.GetTasksResponse;

import java.util.List;
import java.util.Map;

import static common.configs.ApiConfigs.*;
import static common.handlers.RequestAPI.getHeaderBeDefault;
import static common.handlers.matcher.CompareNew.compareTwoObjectTheSame;

public class TodoistStepDef {

    private final String nameProject = "AutoTest";
    private final String goalText = "AutoTest Todoist";

    TodoistPage todoistPage = new TodoistPage();

    private Map<String, Object> request() {
        return getHeaderBeDefault(AUTHORIZATION_VALUE);
    }

    @Given("Create test project via API")
    public void createTestProjectViaAPI() {
        Map<String, Object> request = request();
        CreateProjectRequest body = new CreateProjectRequest();
        body.setName(nameProject);
        Response res = RequestAPI.post(TODOIST_PROJECTS, request, body);
        CreateProjectResponse response = Common.gson.fromJson(res.asString(), CreateProjectResponse.class);
        compareTwoObjectTheSame(nameProject, response.getName(), null, null);
    }

    @And("Login into mobile application")
    public void loginIntoMobileApplication() {
        todoistPage.tapContinueWithEmailBtn();
        todoistPage.inputEmail(ACCOUNT);
        todoistPage.tapContinueWithEmailBtn();
        todoistPage.inputPassword(PASSWORD);
        todoistPage.tapLoginBtn();
        todoistPage.hideKeyboard();
        todoistPage.tapMenuBtn();
    }

    @Then("Verify on mobile that project is created")
    public void verifyOnMobileThatProjectIsCreated() {
        String actualName = todoistPage.getNameLastProject();
        compareTwoObjectTheSame(nameProject, actualName, null, null);
        todoistPage.backAndroid();
    }

    @Given("Create test task via mobile application in test project")
    public void createTestTaskViaMobileApplicationInTestProject() {
        todoistPage.tapQuickAddTaskBtn();
        todoistPage.inputGoal(goalText);
        todoistPage.backAndroid();
    }

    @Then("Verify that task created correctly")
    public void verifyThatTaskCreatedCorrectly() {
        Map<String, Object> request = request();
        Response res = RequestAPI.get(TODOIST_TASKS, request);
        List<GetTasksResponse> listTasks = Common.gson.fromJson(res.asString(), new TypeToken<List<GetTasksResponse>>() {
        }.getType());
        String lastTaskContent = listTasks.get(listTasks.size() - 1).getContent();
        compareTwoObjectTheSame(goalText, lastTaskContent, null, null);
    }

    @And("Open test project")
    public void openTestProject() {
        todoistPage.tapLastProject();
    }

    @And("Created test task")
    public void createdTestTask() {
        todoistPage.tapQuickAddTaskBtn();
        todoistPage.inputGoal(goalText);
        todoistPage.backAndroid();
    }

    @And("Complete test task")
    public void completeTestTask() {
        Map<String, Object> request = request();
        Response res = RequestAPI.get(TODOIST_TASKS, request);
        List<GetTasksResponse> listTasks = Common.gson.fromJson(res.asString(), new TypeToken<List<GetTasksResponse>>() {
        }.getType());
        Serenity.setSessionVariable("listTasks").to(listTasks);
        todoistPage.completeLastTask();
    }

    @And("Reopen test task via API")
    public void reopenTestTaskViaAPI() {
        Map<String, Object> request = request();
        List<GetTasksResponse> listTasks = Serenity.sessionVariableCalled("listTasks");
        Long idLastTask = listTasks.get(listTasks.size() - 1).getId();
        Response res = RequestAPI.post(TODOIST_TASKS + "/" + idLastTask + "/reopen", request, "");
        compareTwoObjectTheSame(204, res.statusCode(), null, null);
    }

    @Then("Mobile: Verify that test task appears in your test project")
    public void mobileVerifyThatTestTaskAppearsInYourTestProject() throws InterruptedException {
        Thread.sleep(10000);
        todoistPage.swipe(500, 500, 500, 1700, 500);
        todoistPage.getNameLastTask();
        String actualTaskName = todoistPage.getNameLastTask();
        compareTwoObjectTheSame(goalText, actualTaskName, null, null);
    }
}