package digital.lights.factory;

import digital.lights.configuration.Configuration;
import org.apache.commons.cli.CommandLine;

public interface ConfigurationReader {
    Configuration create(CommandLine cmd);

}
