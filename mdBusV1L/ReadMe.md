## mdBusV1L Module 🚌

An app is going to be created to manage the city's bus services.
For this purpose, the classes Bus, Servicio, EnMatricula, PorLinea, Coincide and the interface Criterio will be created, all in the "buses" package.

- Unless specified otherwise, instance variables will be private, and methods will be public.
- You can add private methods as needed. 

**Bus Class**
- Create the Bus class that holds information about a city bus, including the bus code (int codBus), license plate (String matricula), and the line it belongs to (int codLinea). The class should have a constructor with arguments for the bus code and license plate.
- Create the void setCodLinea(int codLinea) method that assigns the bus's line code.
- Define the methods int getCodBus(), String getMatricula(), and int getCodLinea() to return the bus code, license plate, and line code, respectively.
- Two buses are considered equal if their bus code and license plate match, regardless of the case of the license plate letters.
- The string representation of a bus (toString() method) should display all three instance variables, for example: Bus(675, 2959CDN, 25).

**Servicio Class**
- Create the Service class that collects information about buses in a city. This class includes a String for the city name and a collection (a list named buses) of buses. Define a constructor that takes the city name as an argument and creates the list to store buses.
- Define the method String getCiudad() that returns the city name and another method List<Bus> getBuses() that returns the list of buses.
- To include buses in the list, define the void leeBuses(String file) method that reads bus data from the file, which should be in the format as shown in the provided example.
- When there is an error in reading the data for a bus, such as missing or incorrect data, the error should be displayed in the console, and the program should continue reading the rest of the input file.

**MainPrueba Class**
- Create a MainPrueba application in the default package that creates a service for the city of Málaga with the buses from the "buses.txt" file. This application should display the city and all the buses, one by one, in the console.

**Criterio Interface**
- Create the Criterion interface that contains the boolean method esSeleccionable(Bus bus), indicating whether the bus passed as an argument should be selected based on this criterion.

**EnMatricula Class**
- Create the LicensePlate class that implements a Criterion and stores a string provided in the constructor.
- Implement the selection method so that the argument bus is selectable if its license plate contains the string given in the constructor.
- Redefine the toString() method to display "Buses whose license plate contains xxx".

**PorLinea Class**
- Create the ByLine class that implements a Criterion and stores a line code provided in the constructor.
- Implement the selection method so that the argument bus is selectable if its line code matches the one given in the constructor.
- Redefine the toString() method to display "Buses from line xxx".

**Coincide Class**
- Create the Matches class that implements a Criterion and stores a bus provided in the constructor.
- Implement the selection method so that the argument bus is selectable if it matches the one given in the constructor.
- Redefine the toString() method to display "Bus xxxxxxx".

**Servicio Class (Continuation)**
- Add new methods to the Service class.
- Create the List<Bus> filtra(Criterio criterio) method, which returns a list of buses from the service that meet the given criterion.
- To save the selected buses to a file, two methods are needed. The first, void guarda(String file, Criterio criterio) throws FileNotFoundException, saves the buses that meet the specified criterion to the file. It uses another method, void guarda(PrintWriter pw, Criterio criterio), to save the selected buses to the output device provided as the first argument.
