package common.configs;

import com.typesafe.config.Config;

public class ConfigImpl {

    private final Config conf;

    public ConfigImpl(String serviceName) {
        common.configs.Configs.Builder builder = common.configs.Configs.newBuilder()
                .withResource(serviceName + "." + Env.get().getName() + ".conf")
                .withResource(serviceName + ".conf");
        this.conf = builder.build();
    }

    public Config getConf() {
        return this.conf;
    }
}
