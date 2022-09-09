package digital.lights.factory;

class XmlConfigurationReaderTest implements ConfigurationReaderTest {
    public ConfigurationReader configurationReader() {
        return new XmlConfigurationReader();
    }

    public String[] args() {
        return new String[]{"--configuration=my_config.xml"};
    }

    public String expectedLogPath() {
        return "C:\\Temp";
    }

    public String expectedLogLevel() {
        return "WARN";
    }
}