package common.configs;

import com.typesafe.config.Config;

public class ApiConfigs {

    public static final String APPLICATION_JSON = "application/json";
    public static final String AUTHORIZATION_VALUE = "Bearer 5bb68942962964d9cdcf3e704992a072aee29514";

    public static final String ACCOUNT = "abcxyz125haha@gmail.com";
    public static final String PASSWORD = "Test123456@@";


    private static final Config conf = new ConfigImpl("automation").getConf();
    public static final String TODOIST_PROJECTS = conf.getString("todoist.todoistProjects");
    public static final String TODOIST_TASKS = conf.getString("todoist.todoistTasks");

    private ApiConfigs() {
        throw new IllegalStateException("Utility class");
    }
}
