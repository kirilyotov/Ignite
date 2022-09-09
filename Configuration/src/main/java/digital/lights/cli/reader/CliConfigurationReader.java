package digital.lights.cli.reader;

import digital.lights.configuration.Configuration;
import org.apache.commons.cli.CommandLine;

public class CliConfigurationReader {
    public static Configuration create(CommandLine cmd) {
        return new Configuration(cmd.getOptionValue("ll"), cmd.getOptionValue("lp"));
    }
}
