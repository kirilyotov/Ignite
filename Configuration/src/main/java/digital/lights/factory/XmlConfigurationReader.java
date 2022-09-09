package digital.lights.factory;

import digital.lights.configuration.Configuration;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public class XmlConfigurationReader implements ConfigurationReader {

    @Override
    public Configuration create(CommandLine cmd) {
        XMLConfiguration configuration;
        try {
            configuration = new XMLConfiguration(cmd.getOptionValue("c"));
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
        return new Configuration(configuration.getString("log.path"), configuration.getString("log.level"));
    }
}
