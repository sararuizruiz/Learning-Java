## Módulo mdJarras 🍺

El objetivo de este ejercicio es crear una clase **Jarra** que utilizaremos para “simular” algunas de
las acciones que podemos realizar con una jarra. 

Nuestras jarras van a poder contener cierta cantidad de agua. Así, cada jarra tiene una
determinada capacidad (en litros) que será la misma durante la vida de la jarra (dada en el
constructor). En un momento determinado, una jarra dispondrá de una cantidad de agua que
podrá variar en el tiempo.

Las acciones que podremos realizar sobre una jarra son:
* Llenar la jarra por completo desde un grifo.
* Vaciarla enteramente.
* Llenarla con el agua que contiene otra jarra (bien hasta que la jarra receptora quede
colmada o hasta que la jarra que volcamos se vacíe por completo).

Además, se creará la clase **Mesa** que dispondrá de dos jarras A y B (jarraA y jarraB). Se pide: 
* Un constructor que cree una mesa con dos jarras de tamaño inicial dados.
* Métodos para llenar las jarras A y B respectivamente y para vaciarlas.
* Métodos que vuelque la jarra A sobre la jarra B y viceversa.
* Métodos que devuelvan los contenidos y capacidades de las jarra A y B.
* Método que devuelva el contenido total de las jarras.
* Método String toString() que muestre las dos jarras que hay en la mesa.

Por último, se pide crear una aplicación que cree una mesa con valores iniciales de las jarras de 7 y 5 litros y
realice las operaciones necesarias para que en una de las jarras quede 1 litro.


