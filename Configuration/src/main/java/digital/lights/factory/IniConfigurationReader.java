package digital.lights.factory;

import digital.lights.configuration.Configuration;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalINIConfiguration;

public class IniConfigurationReader implements ConfigurationReader {
    @Override
    public Configuration create(CommandLine cmd) {
        HierarchicalINIConfiguration configuration;
        try {
            configuration = new HierarchicalINIConfiguration(cmd.getOptionValue("c"));
        } catch (ConfigurationException e) {
            throw new RuntimeException("Problem with reading file!");
        }
        return new Configuration(configuration.getString("log.LogPath"), configuration.getString("log.LogLevel"));
    }

}
