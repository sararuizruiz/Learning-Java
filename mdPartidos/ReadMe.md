## mdPartidos 🗳️

An application is intended to be developed in Java to calculate the seats allocated to different political parties participating in an election based on the number of votes obtained and the available seats for distribution. N seats must be distributed following some criterion for seat distribution. The selection criterion will be provided by the interface `CriterioSeleccion`, and the classes defining that interface will offer a specific criterion. For example, `DHontSimple` provides the criterion for the simple D'Hondt law, the class `DHont` implements the complete D'Hondt law, and the class `Proporcional` implements a proportional criterion. To achieve this, proceed according to the instructions and solve the problems presented in the following sections. Unless specified otherwise, instance variables will be private, methods and constructors will be public, and work will be done in the `partidos` package.

1. Create the unchecked exception `EleccionesException`, which will be thrown in any exceptional situation.
2. Define the class `Partido`, representing a political party by its name (`String`) and a number of votes (`int`). Define the following constructors and methods:
   a) Constructor with two arguments indicating the party's name and the number of votes obtained.
   b) Public methods to get the name (`String getNombre()`) and the number of votes (`int getVotos()`).
   c) Override the `boolean equals(Object)` method so that two parties with the same name (regardless of case) are considered equal.
   d) Override the `toString()` method to present a party as: `name : votes`.
3. Create the interface `CriterioSeleccion`, including the method:
   `Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc)` that, given a list of parties and a number of seats, distributes the seats among the parties following the corresponding criterion. It returns a mapping where each party is associated with the number of seats obtained.
4. Construct the class `Elecciones`, containing an instance variable as a list of parties.
   a) Define the static private method `Partido stringToPartido(String dato)` that creates a party with the information in the string `dato` and returns it. The data will have the format as in the example `"PESAO,455342"`. The separator will be `","`, and it may appear one or more times. Any error will throw an `EleccionesException` indicating the reason.
   b) Define the method `public void leeDatos(String[] datos)` that creates the list of parties and fills it with the information from the array of data passed as an argument.
   c) Define the method `public void leeDatos(String nombreFichero) throws IOException` that creates the list of parties with the information provided in the file. Each line contains a party's information.
   d) Define the method `public Map<Partido, Integer> generaResultados(CriterioSeleccion cs, int numEsc)` that, knowing the seat selection criterion and the number of seats to be distributed, returns a correspondence that associates each party with the number of seats they are entitled to.
   e) Define the method `public void presentaResultados(String nombreFichero, Map<Partido, Integer> map) throws FileNotFoundException` that generates in the given file name a list of parties with the number of seats they are entitled to. If a party has no representation, it will appear with the phrase "Sin representación". The output format will be similar to the example provided.
   Among the different seat selection criteria (classes implementing the `CriterioSeleccion` interface), we will consider the simple D'Hondt law, the D'Hondt law, and a proportional criterion.
5. To implement the criteria, we'll use an auxiliary class called `Token`, maintaining as variables a political party (`Partido` class object) and a ratio (`double`). Define the following constructors and methods for this class:
   a) Constructor with two arguments, the first being an object of the `Partido` class and the second a `double` representing the ratio.
   b) Methods to get the ratio (`double getRatio()`) and the party (`Partido getPartido()`).
   c) A natural ordering criterion that orders the tokens by ratio from highest to lowest and, in case of equality, by party name.
   d) A method `public static Set<Token> seleccioneTokens(Set<Token> tks, int numEsc)` that selects the first `numEsc` tokens from the set `tks` (where `tks` will be sorted).
   e) A method `public static Map<Partido, Integer> generaResultados(Set<Token> tks)` that generates and returns a correspondence that assigns to each party appearing in the set `tks` an integer indicating how many times the party appears in the set.
6. Define the class `DHontSimple`, which defines the simplified D'Hondt law as a selection criterion. The `ejecuta` method defines the seat selection criterion per party. As arguments, it has the list of parties and the number of seats to be distributed. The algorithm will be as follows:
   a) For each party, create as many tokens as there are seats to distribute. The second argument of the constructor will be successively the number of votes for the party divided by the values 1, 2, 3... up to the number of seats to distribute.
   b) Sort the tokens according to their natural order.
   c) Select the first tokens, as many as the number of seats to distribute.
   d) Return a correspondence associating each party with the number of selected tokens.
   Now suppose that parties that do not reach a minimum percentage of votes should not be considered when distributing seats (as the D'Hondt law does). To address this, we will create the class `DHont`, behaving like the `DHontSimple` class but taking this into account.
7. Define the class `DHont`, which behaves like the `DHontSimple` criterion but also contains an attribute `double minPor` representing the minimum admissible percentage of votes to count a party. Define the following constructors and methods:
   a) The constructor `DHont(double mp)` with the admissible minimum percentage. The minimum percentage must satisfy `0 <= mp < 15`. Otherwise, an exception should be thrown.
   b) Redefine the selection criterion so that before applying the `DHontSimple` criterion, filter out those parties that do not reach the minimum percentage.
   Finally, the proportionality criterion (class `Proporcional`) will be implemented.
8. Define the class `Proporcional`. The `ejecuta` method defines the criterion for selecting seats per party proportionally. As arguments, it has the list of parties and the number of seats to be distributed. The algorithm will be as follows:
   a) Calculate how many votes are needed to get a seat. To do this, calculate the total votes cast and divide by the number of seats to be distributed (variable `vpe`).
   b) For each party, create as many tokens as there are seats to distribute. The second argument of the constructor will be successively the number of votes for the party minus the values `0*vpe`, `1*vpe`, `2*vpe`, `3*vpe`... up to the number of seats

 to distribute minus 1, divided by `vpe`.
   c) Sort the tokens according to their natural order.
   d) Select the first tokens, as many as the number of seats to distribute.
   e) Return a correspondence associating each party with the number of selected tokens.
9. To automate the process of generating elections, define the class `EleccionesManager` with the following instance variables:
   - A `String[] datos` array with the data of the political parties.
   - An integer `numEsc` indicating the number of seats to be distributed.
   - A `CriterioSeleccion cs` indicating the criterion with which seats are distributed.
   - An `Elecciones elecciones` that will store the elections it will handle.
   - A `String fEntrada` holding the name of the input file.
   - A `String fSalida` holding the name of the output file.
   - A boolean `consola` indicating whether the results should be displayed in the console.
   a) Define a constructor that takes the elections it should handle as an argument: `public EleccionesManager(Elecciones elecciones)`.
   b) Define the following methods:
      - `public EleccionesManager setDatos(String[] datos)` providing the array of data. This method should return the receiver.
      - `public EleccionesManager setCriterioSeleccion(CriterioSeleccion cs)` providing the criterion for selecting representatives. This method should return the receiver.
      - `public EleccionesManager setNumEsc(int numEsc)` providing the number of seats to distribute. This method should return the receiver.
      - `public Elecciones setEntrada(String fEntrada)` providing the name of the input file. This method should return the receiver.
      - `public Elecciones setSalida(String fSalida)` providing the name of the output file. This method should return the receiver.
      - `public Elecciones setConsola(boolean consola)` providing a boolean indicating whether the results should be displayed in the console. This method should return the receiver.
   c) Define the private method `void verify()` that verifies that the data contained in the elections are correct:
      - There is only one data entry, either through an array or through a file (one must be present).
      - There is a selection criterion (not null).
      - There are seats to distribute (it's positive).
      - If there is an output file, meaning `fSalida` is not null, or there is output in the console (both can be present, but at least one must be).
      If any of these conditions fail, an `ExceptionElecciones` should be thrown indicating the reason.
   d) Define the method `public void build() throws IOException` that performs the following actions:
      - Verify that the data stored in the instance variables are correct.
      - Ask elections to read the data from the selected input.
      - Ask elections to generate the correspondence `Map<Partido, Integer>` based on the selection criterion `cs`, the list of parties, and the number of seats `numEsc`.
      - Ask elections to present the obtained results in the selected output.
   Use the provided `MainElecciones` class to test the functionality.
