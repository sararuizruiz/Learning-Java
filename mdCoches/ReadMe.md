## mdCoches Module 🚙

Create the 'Coche' class in the 'coches' package, whose instances store the name of the car and its price (before taxes). 
The total price of a car is calculated by applying a VAT (Value Added Tax or IVA in Spanish) to the marked price.
This VAT may vary (by default, the VAT is 16%), but it will always be the same for all cars. 
Provide methods to change the VAT, calculate the total price, and display the car as a string with the format:

<Car_Name> -> <Total_Price>

An imported car ('Coche Importado') is a car for which, in addition to the VAT, we apply a homologation tax. The homologation tax is specific to each vehicle and is provided at the time of its creation. The total price of an imported car is calculated like any other car, but now we need to add this new tax. Create the 'CocheImportado' (Imported Car) Class to maintain information about imported cars.

Test the classes with the provided test class 'EjCoches'.
The output of the 'EjCoches program should be':

Seat Panda -> 17400.0 <br />
Ferrari T-R -> 83400.0 <br />
Seat Toledo -> 24360.0 <br />
Jaguar XK -> 53560.0 <br />
Porche GT3 -> 58040.0 <br />
Con IVA de 18% <br />
Seat Panda -> 17700.0 <br />
Ferrari T-R -> 84700.0 <br />
Seat Toledo -> 24780.0 <br />
Jaguar XK -> 54380.0 <br />
Porche GT3 -> 58920.0 <br />
