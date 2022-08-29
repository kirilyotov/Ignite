
# Figure project 
### Structure of project files
    lights.digital    
        ├──commandLine
        │      ├──CommandLine.java                  #interraction with user
        │      ├──Commands.java                     #enum class with functions, implements CommandsInstance
        │      └──CommandsInstance.java             #interface 
        ├──createfigures
        │      ├──CreteFigures.java                 #imolementation of functions
        │      └──Function.java                     #interface wihth functions to be implemented
        ├──factory
        │      ├──input
        │      │    ├──Inputfactory.java            #interface
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
        │        └──Utils.java                      #static methods wiht info for user
        └──Main.java                                #start point of program
