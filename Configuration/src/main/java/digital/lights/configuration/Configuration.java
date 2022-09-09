package digital.lights.configuration;

import lombok.Getter;

public class Configuration {
    final @Getter String logFilePath;
    final @Getter String logLevel;

    public Configuration(String logFilePath, String logLevel) {
        if (logFilePath == null || logFilePath == null) {
            throw new IllegalArgumentException("Not given log-level or log-path!");
        }
        this.logFilePath = logFilePath;
        this.logLevel = logLevel;
    }
}
