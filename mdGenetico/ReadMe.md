## mdGenetico Module 🧬

Genetic algorithms are used to approximately solve optimization problems when exact algorithms are not feasible. They are inspired by the theory of evolution and work by manipulating a set of tentative solutions to a problem. These solutions are referred to as individuals, and the set of solutions is called a population. In the simplest case, which we will discuss, an individual is composed of a binary string (a sequence of zeros and ones) and is associated with a real value that represents its approximation to an optimal solution, known as its fitness for the problem. Each digit in the binary sequence is called a gene, and the entire sequence is referred to as a chromosome. The only information these algorithms need about the problem they are solving is how to calculate the fitness of a solution, known as the fitness function.

A genetic algorithm proceeds as follows: First, all individuals in the population are initialized with random sequences of zeros and ones. Then, the algorithm enters a loop that repeats a specified number of times (generations). Within this loop, two individuals (parents) are randomly selected from the population, their chromosomes are combined to create a new chromosome, which is then mutated. The resulting chromosome forms a new individual, which is compared to the worst individual in the population. If its fitness is higher, it replaces the worst individual; otherwise, it is discarded.

In cases where an exceptional situation arises, a RuntimeException (or a subclass that suits the situation better) should be thrown.

The following classes and interfaces will be built in the "genetico" package:

1) The "Cromosoma" class with the methods as described in the attached diagram. Important points to note include:

   - To store the data of a chromosome, an array of integers should be used, where each position represents a gene. This array should be visible to subclasses and classes within the package.
   - The constructor of the "Cromosoma" class will take the length of the chromosome (number of genes it contains) and a boolean value indicating whether to randomly assign a value of zero or one to each gene (true) or initialize them with the default value of 0 (false).
   - Getter and setter methods with the name "gen" will allow you to access and set the value of each gene in the chromosome, and `getLongitud()` will let you query the number of genes.
   - The `mutar(double)` method should traverse all genes in the chromosome passed as a parameter, inverting their value (from 0 to 1 or from 1 to 0) according to the mutation probability parameter, which should be applied to each gene separately.
   - Define a copy constructor for this class that takes another chromosome as an argument and makes a copy.

2) The "Problema" interface with a single method, `evalua(Cromosoma)`, which should return the fitness value associated with the chromosome provided as an argument for the problem it represents.

3) The "Individuo" class, composed of a "Cromosoma" and its fitness value. Key points to consider include:

   - This class should have two constructors: the first with two parameters, the length of the chromosome and the problem to be solved, and the second, also with two parameters, which are the chromosome to be associated with the individual and the problem. The first constructor should create a random chromosome, and the second should generate a copy of the chromosome passed as a parameter before associating it with the object being created. In both constructors, the "Problema" class object will be used solely to evaluate the chromosome and assign the corresponding fitness value in the given problem.
   - The `getCromosoma()` method should return a copy of the "Cromosoma" object associated with the "Individuo" object.
   - The fitness value of an "Individuo" object can be obtained using the `getFitness()` method.

4) The "OneMax" class that implements the "Problema" interface, knowing that, in this problem, the fitness of an individual is determined by the number of "1" digits in its chromosome, and "CeroMax" is the same but with "0" digits.

5) The "Poblacion" class, where a population consists of a fixed number of individuals and will be implemented using an array of "Individuo." Furthermore:

   - The constructor will receive as parameters the population size (number of individuals), the length of individuals (number of genes in their chromosomes), and the problem to be solved (an object implementing the "Problema" interface). With this data, it should create a population of randomly generated individuals.
   - The `getNumIndividuos()` method should return the number of individuals in the population (population size).
   - The `getIndividuo(int)` method will return the i-th individual in the population.
   - The `mejorIndividuo()` method returns the individual with the highest fitness value in the population.
   - The `reemplaza(Individuo)` method will replace the worst individual in the population (the one with the lowest fitness value) with the individual passed as a parameter, but only if the latter is better (higher fitness).

6) The abstract class "AlgoritmoGenetico," knowing that each genetic algorithm will store necessary information about a problem, a population of tentative solutions, the probability of gene mutation in individuals, and the number of steps to be taken. Additionally, consider the following:

   - The constructor of this class should receive the population size it will use, the length of the individuals in that population, the number of algorithm steps (generations), the probability of gene mutation in the chromosome, and the problem to be solved. The constructor should create the population of individuals.

   - The `ejecuta()` method should execute the following sequence as many times as indicated by the number of steps: select two individuals from the population randomly, take their chromosomes and recombine them using the abstract method `recombinar(Cromosoma, Cromosoma)`, mutate the result with the indicated probability, and finally, create an individual with the resulting chromosome that is inserted into the population, replacing the worst individual if and only if it is better. Finally, it should return the best individual in the population after the loop terminates.

7) There are many recombination operators that can be used to combine individuals. Two of the most well-known ones are single-point recombination and uniform recombination. In single-point recombination, a random number z is generated between zero and the chromosome length. The first z genes of the resulting individual are taken from the first parent, and the rest are taken from the second. In uniform recombination, the value of each gene in the resulting individual is randomly chosen from one of the parents. Given this information, you should construct the subclasses "AGUnPunto" and "AGUniforme" of "AlgoritmoGenetico" to implement single-point recombination and uniform recombination, respectively, in the "recombinar" method. The constructor for these classes should have the same signature as the one in the "AlgoritmoGenetico" class.

To test the functionality of the two types of genetic algorithms implemented, you can use the "TestGenetico" class.

### UML Diagram

<img width="944" alt="Screenshot 2023-10-23 at 09 16 39" src="https://github.com/sararuizruiz/Learning_Java/assets/75987848/9644e4ca-0c20-4e6b-ae3f-4975af699b61">




