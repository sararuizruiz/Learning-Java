## mdMastermindL module 🎮

It is desired to implement a game (Mastermind, in the "masterMind" package) in which the user has to guess a randomly generated secret combination of non-repeating digits by the program. The user will have the opportunity to make multiple attempts to guess the secret combination, with the program responding to each of these attempts with the number of correctly placed digits and the number of digits that appear in the secret combination but in a different position. For example, if the secret combination is 4235, and the player tries 4350, the program will respond that the number of correctly placed digits is 1 (the digit 4) and the number of misplaced digits is 2 (the digits 3 and 5). To achieve this:

1) Create the named tuple "Movimiento," whose instances maintain information about an attempt (as a String) and two integers, which indicate the number of correctly placed and misplaced digits.

2) Define the "MasterMindException" class, which will be used to create exceptions in case of any type of error. This exception is not required to be handled.

3) Create the "MasterMind" class, which will contain a secret combination of digits (a String), so that any user of this class can try to guess the combination. No combination of digits can contain repeated digits. Here are the requirements:

   - A constructor that creates an instance of Mastermind given the length of the digit combinations. There will be a second constructor with no arguments that will create an instance of the game with combinations of a default length (in this case, 4). The secret combination will be generated at the time of the Mastermind's creation. A non-positive argument or one greater than the number of available digits (10) will result in throwing the "MasterMindException."
   - Define the "int getLongitud()" method to provide the length of the combination in this game.
   - Define a private "boolean validaCombinacion(String cifras)" method that checks whether a character string corresponds to a valid move. A string is a valid move if it has the correct length, i.e., the number of digits required by the game, all characters are numbers, and it does not contain repeated digits.
   - Define a public "Movimiento intento(String cifras)" method that, given a string of digits, checks if it is a valid string and then returns a "Movimiento" object that contains the digits, the number of digits that appear in the secret combination in the same position, and the number of digits in different positions. If the string of digits is not valid, it will throw the "MasterMindException."
   - Define a public "String getSecreto()" method that allows knowing the secret combination. It will return a character string with the secret combination.

4) Create the "MasterMindMemoria" class, whose objects behave the same as those of the "MasterMind" class, except that they remember all valid moves that have been attempted so far, not allowing the user to repeat digit combinations. Repeated combinations will trigger the "MasterMindException." Here are the requirements:

   - Constructors with arguments, just like those in the "MasterMind" class.
   - Redefine the "Movimiento intento(String cifras)" method to have the expected behavior.
   - Define a "List<Movimiento> movimientos()" method that provides a list of valid moves already made.

Test the classes with the provided "TestMasterMind" program.

