# Figure project #
- - - - - - - - 

## Structure ##
- - - - - - - - 
* [Add new commands and figures](#add-new-commands-and-figures)
* [Commands](#commands)<br>
* [Structure-of-project-files](#structure-of-project-files)
* [Used resources](#used-resources)

## Add new commands and figures ##
- - -
>To add new command should be edited `lights.digital.commandline.Commands.java` and `lights.digital.engine.Engine.java` 
> for functionality and `lights.digital.utils.Utils.java` for user output information.

>For adding new figure (for example square) should be created 3 classes. 

Ex: creating figure Square
````
    lights.digital.figures.Square.java which implements Figures.java
    lights.digital.factory.random.RandomSquareFactory.java which implements InputFactory.java
    lights.digital.factory.input.SquareFactory.java which implements RandomFactory.java
````
## Reflection ##

```java
    Reflections reflections = new Reflections("lights.digital.factory.random");
    Set<Class<? extends RandomFactory>> subTypes =
        reflections.getSubTypesOf(RandomFactory.class);
```


## Commands ##
- - - - - - - - 
| Command   | Description                                 |
|-----------|---------------------------------------------|
| random    | generate random figures                     |
| stdin     | read figures from console                   |
| file      | read figures from file                      |
| delete    | delete figure on position given by user     |
| duplicate | duplicate figure on position given by user  |
| save      | save all figures to file                    |
| help      | get instructions with commands              |
| exit      | exit from program                           |




## Structure of project files ##
- - - - - - - - 
    lights.digital    
        ├──commandline
        │      ├──CommandLine.java                  #interraction with user
        │      ├──Commands.java                     #enum class with functions, implements CommandsInstance
        │      └──CommandsInstance.java             #interface 
        ├──engine
        │      ├──Engine.java                       #imolementation of functions
        │      └──EngineFunction.java               #interface wihth functions to be implemented
        ├──factory
        │      ├──input
        │      │    ├──InputFactory.java            #interface
        │      │    ├──CircleFactory.java           #creates cicle from given string, implements Inputfactory
        │      │    ├──RectangleFactory.java        #creates rectangle from given string, implements Inputfactory
        │      │    ├──TriangleFactory.java         #creates triangle from given string, implements Inputfactory
        │      │    └──FigureFactory.java           #
        │      └──random 
        │           ├──RandomFactory.java           #interface
        │           ├──RandomCircleFactory.java     #generrates random circle, implements RandomFactory
        │           ├──RandomRectangleFactory.java  #generates random rectangle, implements RandomFactory
        │           ├──RandomTriangleFactory.java   #generates random triangle, implements RandomFactory
        │           └──RandomFigureFactory.java     #random call of RadnomRactory subclasses with reflection
        ├──figures
        │      ├──Figure.java                       #interface
        │      ├──Circle.java                       #implements Figure
        │      ├──Triangle.java                     #implements Figure
        │      └──Rectangle.java                    #implements Figure
        ├──file
        │      ├──FileFactory.java                  #interface
        │      └──FileIO.java                       #reading and writing to file
        ├──units
        │      └──Utils.java                        #static methods wiht info for user
        └──Main.java                                #start point of program

## Used resources ##
- - -

* [https://www.baeldung.com/a-guide-to-java-enums](https://www.baeldung.com/a-guide-to-java-enums)<br>
* [https://code.google.com/archive/p/reflections/](https://code.google.com/archive/p/reflections/)
* [https://refactoring.guru/design-patterns/factory-method](https://refactoring.guru/design-patterns/factory-method)
* Cătălin Tudose (2020) JUnit in Action, 3rd ed