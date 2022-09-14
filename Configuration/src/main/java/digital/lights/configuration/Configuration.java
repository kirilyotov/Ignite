package digital.lights.configuration;

import digital.lights.path.validator.PathValidator;
import lombok.Getter;

public class Configuration {
    final @Getter String logFilePath;
    final @Getter String logLevel;

    public Configuration(String logFilePath, String logLevel) {
        if (logFilePath == null || logLevel == null) {
            throw new IllegalArgumentException("Not given log-level or log-path!");
        }
        if (!PathValidator.isValidPath(logFilePath) || logFilePath == "") {
            throw new IllegalArgumentException("Not correct logFilePath!");
        }
        this.logFilePath = logFilePath;
        this.logLevel = logLevel;
    }
}
