## mdUrna Module 🗳️

The goal of this exercise is to create an Urn class whose objects can contain white and black balls and allow us to perform some basic operations on it.
* The class will have a pair of instance variables, 'negras' and 'blancas', to store the number of balls of each color.
* The Urn class will have a constructor that allows creating instances of the class with the initial number of white and black balls passed as parameters. The constructor should ensure that urns with a negative number of balls are not created. In case any of the parameters is negative, it should throw an IllegalArgumentException.
* In addition, it will include methods to:
    * Check the total number of balls it contains (public int totalBolas()).
    * Randomly extract a ball and know its color (public ColorBola extraerBola()). The color will be given by an enumerated type ColorBola with two elements: 'Blanco' and 'Negro'. The enumerated type ColorBola should be defined as a static inner class to the Urn class. To randomly extract a ball, you need to add the number of white and black balls and pick a random number between 1 and that sum. If that number is less than or equal to the number of white balls, it is assumed that the ball drawn is white; otherwise, it's black. Use the java.util.Random class for generating random numbers. If there are no balls, it should throw a NoSuchElementException.
    * Introduce a ball of a specific color.

Create an application that creates an urn, taking the number of white and black balls as arguments when executing the application, and perform the following experiment:
* While there is more than one ball in the urn, draw two balls.
* If both are of the same color, add a white ball to the urn; if they are of different colors, add a black ball (it is assumed that there are enough balls of both colors outside the urn).
* Finally, when only one ball remains, draw it and display its color.

Use the parseInt() method of the Integer class in java.lang to convert a String into an int value.
Inform the user through standard output of any errors that may occur.
Analyze the results obtained regarding the color of the final ball depending on the initial number and color of the balls.

### Result of the analysis

The color of the final ball depends only on the parity of the initial number of black balls passed as an argument.
If the initial number of black balls is even ---> The final ball will be white.
If the initial number of black balls is odd  ---> The final ball will be black.

Explanation:
I extract balls in pairs, if they are of different colors, I have removed a black one but then put another black one back in,
so the number of black balls remains CONSTANT (and therefore its parity).
If, on the other hand, the balls are of the same color, I either take out two white ones and put back one white one
(the number of black balls remains constant and therefore its parity), or I take out two black ones and put back one white one, so the number of black balls decreases by two
(BUT, importantly, the PARITY remains the same).
Therefore, regardless of the starting point, the parity of the number of black balls will NEVER change.
If it starts as even, it will always be even and can never be 1. The remaining ball that stands alone must be white.
If it starts as odd, it will always be odd and will end up being 1. The returned ball will be black.
