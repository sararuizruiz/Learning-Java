## mdTestL module 🧑‍🎓

You are going to create an application for recording the grades obtained by students in multiple-choice exams for a subject. To do this, you will create the classes `Test` and `TestSubject` in a package named `tests`.

1) The named tuple `Test` holds information about a student's multiple-choice exam. It has the arguments student name (String) and the number of correct and incorrect answers (both of type int) in the test responses. The tuple must include:
   
   a) Redefinition of the `equals` method. Two tests are considered equal when they belong to the same student, regardless of whether the name includes uppercase or lowercase letters.
   
   b) The public method `double calification(double valCorrect, double valIncorrect)` will return the test's grade, considering the number of correct answers multiplied by the valuation of each correct answer plus the number of incorrect answers multiplied by the valuation of each incorrect answer. The valuation of each correct and incorrect answer is provided as parameters.

3) The `TestSubject` class should include information about the subject's name (String), a list of tests, the valuation of correct answers, and the valuation of incorrect answers. In this case, the class will include:
   
   a) Two constructors. One with four arguments where the first determines the subject's name, the second the valuation of each correct answer, the third the valuation of each incorrect answer, and the fourth argument is a list of strings where each entry includes information about a student's results (correct and incorrect answers). The format of each entry will be:
   Last Name, First Name: correct answers + incorrect answers
   If the valuation of correct answers is not positive or the valuation of incorrect answers is not negative or 0, a `RuntimeException` exception will be thrown.
   The second constructor will include only two arguments, one with the subject's name and the other with the list of strings. In this case, it will be assumed that the valuation of correct answers is 1, and the valuation of incorrect answers is 0. In both cases, from the list of strings, you will need to generate the list of `Test` objects. If any line is incorrect, an error message is displayed on the console, and processing continues with the next one.
   NOTE: It is recommended to create a private method, `void extractData(List<String>)`, which is responsible for extracting the information from the data list and populating the list of tests.
   
   b) A public method `double averageGrade()` to calculate the average grade of all the exams.
   
   c) A public method `int passed()` to return the number of passing grades, considering a grade of 5 or higher as a pass.
