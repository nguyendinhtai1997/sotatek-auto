package common.configs;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Supplier;

// {{start:config}}
@Slf4j
public class Configs {
    // This config has withProvidedInfo of the JVM system properties including any custom -D properties
    private static final Config systemProperties = ConfigFactory.systemProperties();
    // This config has access to withProvidedInfo of the environment variables
    private static final Config systemEnvironment = ConfigFactory.systemEnvironment();
    // Always start with a blank config and add fallbacks
    private static final AtomicReference<Config> propertiesRef = new AtomicReference<>(null);

    private Configs() {
    }

    public static void initProperties(Config config) {
        boolean success = propertiesRef.compareAndSet(null, config);
        if (!success) {
            throw new RuntimeException("propertiesRef Config has already been initialized. This should only be called once.");
        }
    }

    public static Config properties() {
        return propertiesRef.get();
    }

    public static Config systemProperties() {
        return systemProperties;
    }

    public static Config systemEnvironment() {
        return systemEnvironment;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    // This should return the current executing user path
    public static String getExecutionDirectory() {
        return systemProperties.getString("user.dir");
    }

    public static <T> T getOrDefault(Config config, String path, BiFunction<Config, String, T> extractor, T defaultValue) {
        if (config.hasPath(path)) {
            return extractor.apply(config, path);
        }
        return defaultValue;
    }

    public static <T> T getOrDefault(Config config, String path, BiFunction<Config, String, T> extractor, Supplier<T> defaultSupplier) {
        if (config.hasPath(path)) {
            return extractor.apply(config, path);
        }
        return defaultSupplier.get();
    }

    public static class Builder {
        private Config conf = ConfigFactory.empty();

        public Builder() {
//      log.info("Loading common.configs first row is highest priority, second row is fallback and so on");
        }

        public Builder withResource(String resource) {
            Config resourceConfig = ConfigFactory.parseResources(resource);
            String empty = resourceConfig.entrySet().size() == 0 ? " contains no values" : "";
            conf = conf.withFallback(resourceConfig);
            log.info("Loaded config file from resource ({}){}", resource, empty);
            return this;
        }

        public Builder withSystemProperties() {
            conf = conf.withFallback(systemProperties);
            log.info("Loaded system properties into config");
            return this;
        }

        public Builder withSystemEnvironment() {
            conf = conf.withFallback(systemEnvironment);
            log.info("Loaded system environment into config");
            return this;
        }

        public Builder withOptionalFile(String path) {
            File secureConfFile = new File(path);
            if (secureConfFile.exists()) {
                //log.info("Loaded config file from path ({})", path);
                conf = conf.withFallback(ConfigFactory.parseFile(secureConfFile));
//      } else {
//        log.info("Attempted to load file from path ({}) but it was not found", path);
            }
            return this;
        }

        public Builder withOptionalRelativeFile(String path) {
            return withOptionalFile(getExecutionDirectory() + path);
        }

        public Builder withConfig(Config config) {
            conf = conf.withFallback(config);
            return this;
        }

        public Config build() {
            // Resolve substitutions.
            conf = conf.resolve();
            if (log.isDebugEnabled()) {
                log.debug("Logging properties. Make sure sensitive data such as passwords or secrets are not logged!");
                conf.root().render();
            }
            return conf;
        }
    }
}
