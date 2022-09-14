package digital.lights.parser;

import digital.lights.cli.reader.CliConfigurationReader;
import digital.lights.configuration.Configuration;
import digital.lights.factory.ConfigurationReaderFactory;
import org.apache.commons.cli.*;

public class CmdParser {
    static public CommandLine parse(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption(new Option("c", "configuration", true, "configuration path"));
        options.addOption(new Option("lp", "log-path", true, "log path"));
        options.addOption(new Option("ll", "log-level", true, "log level"));
        CommandLineParser parser = new DefaultParser();
        return parser.parse(options, args);
    }

    static public void getInstance(CommandLine cmd) {
        Configuration configuration;

        if (cmd.hasOption("c")) {
            try {
                configuration = ConfigurationReaderFactory.crete(cmd);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        } else if (cmd.hasOption("lp") && cmd.hasOption("ll")) {
            configuration = CliConfigurationReader.create(cmd);
        } else {
            throw new IllegalArgumentException("Not correct input!");
        }
        System.out.println(configuration.getLogFilePath());
        System.out.println(configuration.getLogLevel());
    }
}
