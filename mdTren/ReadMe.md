## mdTren Module 🚆

A steam train needs to incorporate some wagons that transport the coal it needs for combustion.
We are going to define two classes, Train ('Tren') and Wagon ('Vagon').
The Wagon class receives an integer as a parameter in the constructor, representing the capacity in tons of coal it can store. In addition to the capacity, a wagon has the amount of coal stored in a private variable called 'carga' (int), indicating the amount of coal it carries. When the wagon is constructed, 'carga' is set to 0.
Define this class and:
* The method 'int carga(int ton)' that attempts to load the wagon with the tons passed as an argument. If 'ton' is greater than the current capacity of the wagon, it loads up to its capacity. The method returns the tons that could not be loaded or 0 if all were successfully loaded.
* The method 'int descarga(int ton)' that unloads the tons passed as an argument from the wagon. It returns the tons that could not be unloaded because the wagon does not have enough load, or 0 if all were successfully unloaded.
* The method 'int getCarga()' that returns the current load of the wagon, and the method 'int getCapacidad()' that indicates how much coal can still fit in the wagon.
* Override the 'String toString()' method so that a wagon with a storage capacity of 20 tons and a current load of 5 is converted into the string 'V(5/20)'.

The Train class receives the number of wagons it will carry and the common capacity for each wagon as parameters in the constructor. The constructor should create a list with the specified number of wagons, each with the specified capacity. This list will be stored in a variable called 'vagones.' Define this class and:
* The method 'void carga(int ton)' that loads the tons it receives as an argument onto the wagons. It adds load to each of the wagons until the train carries a total of 'ton' tons. If a wagon is filled, it moves on to the next one to load the remaining tons. If there are no more available wagons, a new wagon is created, with the capacity specified in the Train class constructor, and it is added to the end of the list to continue the loading process. Therefore, it may be necessary to add more than one wagon to the train to complete the loading.
* The method 'void gasta(int ton)' that simulates the consumption of tons that the train consumes on a journey. To do this, it unloads the necessary tons from each wagon, starting from the first one, until unloading a total of 'ton' tons. If it reaches the end of the train and could not unload all the tons, it should throw an 'IllegalArgumentException' indicating the reason.
* The method 'void optimiza()' that removes empty wagons from the list.
* Override the 'String toString()' method so that a train with three wagons with a total capacity of 20, the first one with a load of 10 tons, the second with 3, and the third one empty, is represented by the string 'Train[V(10/20), V(3/20), V(0/20)]'."
