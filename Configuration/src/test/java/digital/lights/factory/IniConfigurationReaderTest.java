package digital.lights.factory;


class IniConfigurationReaderTest implements ConfigurationReaderTest {
    public ConfigurationReader configurationReader() {
        return new IniConfigurationReader();
    }

    public String[] args() {
        return new String[]{"--configuration=config.ini"};
    }

    public String expectedLogPath() {
        return "C:\\Temp";
    }

    public String expectedLogLevel() {
        return "WARN";
    }

}