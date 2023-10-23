## mdLibreriaV3L module 📚

**The OfertaFlex Interface**
The OfertaFlex interface (in the libreria package) specifies the necessary methods to calculate the discount percentage to be applied to a particular book.

- `getDescuento(Libro): double`
Calculates and returns the percentage discount to be applied to a specific book received as a parameter. If no discount should be applied, it returns zero.

**The OfertaPrecio Class**
The OfertaPrecio class (in the libreria package) implements the OfertaFlex interface and provides a method to calculate the discount percentage based on a specified price threshold. If the base price of the book exceeds the threshold, the discount is applied.

- `OfertaPrecio(double, double)`
Constructs an object with the discount percentage and the price threshold, received as parameters in that order.
- `getDescuento(Libro): double` // [@Override]
Calculates and returns the percentage discount to be applied to a specific book received as a parameter if the base price of the book is greater than or equal to the threshold specified during object construction. If no discount is to be applied, it returns zero.
- `toString(): String` // [@Override]
Returns the textual representation of the object in the following format: "20% discount for books priced at 8 euros or more" as an example: 20%(8).

**The OfertaAutor Class**
The OfertaAutor class (in the libreria package) implements the OfertaFlex interface and provides a method to calculate the discount percentage based on the names of authors specified during object construction.

Note: Comparisons of both author names and book titles should be case-insensitive.

- `OfertaAutor(double, String[])`
Constructs an object with the discount percentage and an array of author names to be considered for the discount, received as parameters in that order.
- `getDescuento(Libro): double` // [@Override]
Calculates and returns the percentage discount to be applied to a specific book received as a parameter if the author's name is in the array of authors specified during object construction. If no discount is to be applied, it returns zero.
- `toString(): String` // [@Override]
Returns the textual representation of the object in the following format: 20%[George Orwell; Isaac Asimov].

**The LibreriaOfertaFlexible Class**
The LibreriaOfertaFlexible class (in the libreria package) is derived from the Libreria class but allows creating and storing books on sale. It contains a reference to an object that implements the OfertaFlex interface.

Note 1: Comparisons of both author names and book titles should be case-insensitive.
Note 2: It is recommended to define private and/or protected methods to simplify and modularize the solution for complex methods.

- `LibreriaOfertaFlexible(OfertaFlex)`
Constructs an empty LibreriaOfertaFlexible object (with no books) and stores the reference to the object for calculating book discounts, received as the first parameter.
- `setOferta(OfertaFlex): void`
Updates the object used for calculating book discounts to the object received as a parameter.
- `getOferta(): OfertaFlex`
Returns the object used for calculating book discounts.
- `addLibro(String, String, double): void` // [@Override]
Creates a new Libro object with the author's name, title, and base price received as parameters. If the calculated discount percentage for this book is not zero, it then creates a new LibroEnOferta object with the author's name, title, and base price received as parameters, along with the discount based on the value calculated by the object for calculating discounts. If a book by the same author with the same title already exists, it replaces the previous book with the new one. Otherwise, it adds the new book to the library.
- `toString(): String` // [@Override]
Returns the textual representation of the object in the following format: (excluding line breaks)
20%[George Orwell; Isaac Asimov] // or another representation of OfertaFlex
[(George Orwell; 1984; 6.20; 20%; 4.96; 10%; 5.456),
(Philip K. Dick; ¿Sueñan los androides con ovejas eléctricas?; 3.50; 10%; 3.85),
(Isaac Asimov; Fundación e Imperio; 9.40; 20%; 7.52; 10%; 8.272),
(Ray Bradbury; Fahrenheit 451; 7.40; 10%; 8.14),
(Alex Huxley; Un Mundo Feliz; 6.50; 10%; 7.15),
(Isaac Asimov; La Fundación; 7.30; 20%; 5.84; 10%; 6.424),
(William Gibson; Neuromante; 8.30; 10%; 9.13),
(Isaac Asimov; Segunda Fundación; 8.10; 20%; 6.48; 10%; 7.128),
(Isaac Newton; Arithmetica Universalis; 10.50; 10%; 11.55)]

**The PruebaLibreria Application**
Develop an application (in an anonymous package) that allows testing the above classes. It should create a LibreriaOfertaFlexible object with an OfertaAutor object that specifies a 20% discount for authors George Orwell and Isaac Asimov. In addition, it should add the following books to the library:

("George Orwell", "1984", 8.20)
("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?", 3.50)
("Isaac Asimov", "Fundación e Imperio", 9.40)
("Ray Bradbury", "Fahrenheit 451", 7.40)
("Alex Huxley", "Un Mundo Feliz", 6.50)
("Isaac Asimov", "La Fundación", 7.30)
("William Gibson", "Neuromante", 8.30)
("Isaac Asimov", "Segunda Fundación", 8.10)
("Isaac Newton", "Arithmetica Universalis", 7.50)
("George Orwell", "1984", 6.20)
("Isaac Newton", "Arithmetica Universalis", 10.50)

When displaying the textual representation of the library, it should show:

20%[George Orwell; Isaac Asimov]
[(George Orwell; 1984; 6.20; 20%; 4.96; 10%; 5.456),
(Philip K. Dick; ¿Sueñan los androides con ovejas eléctricas?; 3.50; 10%; 3.85),
(Isaac Asimov; Fundación e Imperio; 9.40; 20%; 7.52; 10%; 8.272),
(Ray Bradbury; Fahrenheit 451; 7.40; 10%; 8.14),
(Alex Huxley; Un Mundo Feliz; 6.50; 10%; 7.15),
(Isaac Asimov; La Fundación; 7.30; 20%; 5.84; 10%; 6.424),
(William Gibson; Neuromante; 8.30; 10%; 9.13),
(Isaac Asimov; Segunda Fundación; 8.10; 20%; 6.48; 10%; 7.128)]

Next, it should remove the following books:

("George Orwell", "1984")
("Alex Huxley", "Un Mundo Feliz")
("Isaac Newton", "Arithmetica Universalis)

After removal, the textual representation of the library should display (excluding line breaks):

20%[George Orwell; Isaac Asimov]
[(Philip K. Dick; ¿Sueñan los androides con ovejas eléctricas?; 3.50; 10%; 3.85),
(Isaac Asimov; Fundación e Imperio; 9.40; 20%; 7.52; 10%; 8.272),
(Ray Bradbury; Fahrenheit 451; 7.40; 10%; 8.14),
(Isaac Asimov; La Fundación; 7.30; 20%; 5.84; 10%; 6.424),
(William Gibson; Neuromante; 8.30; 10%; 9.13),
(Isaac Asimov; Segunda Fundación; 8.10; 20%; 6.48; 10%; 7.128)]

Finally, it should display the final prices of the following books:

getPrecioFinal("George Orwell", "1984"): 0
getPrecioFinal("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?"): 3.85
getPrecioFinal("Isaac Asimov", "Fundación e Imperio"): 8.272
getPrecioFinal("Ray Bradbury", "Fahrenheit 451"): 8.14
getPrecioFinal("Alex Huxley", "Un Mundo Feliz"): 0
getPrecioFinal("Isaac Asimov", "La Fundación"): 6.424
getPrecioFinal("William Gibson", "Neuromante"): 9.13
getPrecioFinal("Isaac Asimov", "Segunda Fundación"): 7.128
getPrecioFinal("Isaac Newton", "Arithmetica Universalis"): 0
