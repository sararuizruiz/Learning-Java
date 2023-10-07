## mdJarras Module 🍺

The goal of this exercise is to create a **Jar** (Jarra) class that we will use to “simulate” some of the actions that we can perform with a jar.

Our jars will be able to contain a certain amount of water. Thus, each jar has a certain capacity (in liters) that will be the same during the life of the jar (given in the constructor). A jar will have an amount of water that may vary over time.

The actions that we can perform on a jar are:

* Fill the jar completely from a tap.
* Empty it entirely.
* Fill it with the water contained in another jar (either until the receiving jar is full or until the jar we dumped is completely empty).

Additionally, the **Table** (Mesa) class will be created that will have two jars A and B. It is requested:

* A constructor that creates a table with two given initial size jars.
* Methods for filling jars A and B respectively and for emptying them.
* Methods that dump jar A onto jar B and vice versa.
* Methods that return the contents and capacities of jars A and B.
* A method that returns the total content of both of the jars.
* A String toString() method that shows the two jars on the table.

Finally, we are asked to create an application that creates a table with jars of initial values ​​of 7 and 5 liters and performs the necessary operations so that 1 liter remains in one of the jars.
