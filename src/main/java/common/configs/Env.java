package common.configs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Env {
    LOCAL("local"), TEST("test"), SIT("sit");

    private static final Env currentEnv;

    static {
        String env = "local";
        // This comes from -Denv={environment}
        if (Configs.systemProperties().hasPath("env")) {
            env = Configs.systemProperties().getString("env");
        }
        currentEnv = Env.valueOf(env.toUpperCase());
        log.info("Current Env: {}", currentEnv.getName());
    }

    private final String name;

    Env(String name) {
        this.name = name;
    }

    public static Env get() {
        return currentEnv;
    }

    public String getName() {
        return name;
    }
}
