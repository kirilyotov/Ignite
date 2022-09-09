# Configuration project #

## Structure ##

* [Add new file extensions](#add-new-file-extensions)
* [Structure of project files](#structure-of-project-files)
* [Used resources](#used-resources)

## Add new file extensions ##
 
> To add new file extensions should be created only one new file


Ex: creating for file with extension json
````  
    
    lights.digital.figures.factory.JsonConfiguration.java which implements Figures.java
````

Example JsonConfigurationReader implementation:

```java
    public class JsonConfigurationReader implements ConfigurationReader {

    @Override
    public Configuration create(CommandLine cmd) {
        XMLConfiguration configuration;
        try {
            configuration = new JsonConfiguration(cmd.getOptionValue("c"));
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
        return new Configuration(configuration.getString("path"), configuration.getString("level"));
    }
}
```


Example json file:

```
json example:
{
    "path" : "C:\Temp",
    "level" : "WARN"
}
```
## Structure of project files ##

    lights.digital    
        ├──cli.reader
        │      └──CliConfigurationReader.java         #Reades filePath and logLevel form command line 
        ├──configuration
        │      └──Configuration.java                  #Class which holds filds logFilePath and logLevel
        ├──factory
        │      ├──ConfigurationReader.java            #interface
        │      ├──ConfigurationReaderFactory.java     #Using reflection to read Configuration file if format is supported 
        │      ├──IniConfigurationReaader.java        #Creates Configuration instance after reading file with extention .ini
        │      └──XmlConfigurationReader.java         #Creates Configuration instance after reading file with extention .xml
        ├──parser
        │      └──CmdParser.java                    #Using apache commons to parse command line arguments
        └──Main.java                                #Start point of program

## Used resources ##

* [HierarchicalINIConfiguration](https://commons.apache.org/proper/commons-configuration/javadocs/v1.10/apidocs/index.html?org/apache/commons/configuration/HierarchicalINIConfiguration.html)<br>
* [XMLConfiguration](https://commons.apache.org/proper/commons-configuration/javadocs/v1.10/apidocs/org/apache/commons/configuration/XMLConfiguration.html#getDocument())
* [Design patterns](https://refactoring.guru/design-patterns/factory-method)
* [Reflections](https://code.google.com/archive/p/reflections/)
* [.jar file to .exe](http://launch4j.sourceforge.net/)
* [README.md styling](https://github.com/tchapi/markdown-cheatsheet)
* Cătălin Tudose (2020) JUnit in Action, 3rd ed