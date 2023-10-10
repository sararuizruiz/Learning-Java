## mdRectas Module 📏

In this exercise we will implement classes that manipulate points, vectors and lines in the plane.
The following diagram shows the classes and methods that must be defined and their relationships:

<img width="450" alt="Screenshot 2023-10-10 at 16 40 49" src="https://github.com/sararuizruiz/Learning_Java/assets/75987848/492eb054-2bee-4ab8-8c41-1e1f24e155af">

 <br /> <br />

Things to consider:

* The 'Vector' Class stores the representative of a vector, so it will be enough to know (and store) its end. This class will have three constructors:
  with its two components known; with the extreme point; and with an origin point and
an extreme point (in this case the necessary calculations will be made to store only
the end of the equivalent vector with origin at the coordinate origin).
An orthogonal vector to the vector V(x,y) is the vector V(-y,x) (This is, rotated
90 degrees counterclockwise from the previous one). Two vectors
V(vx,vy) and V(ux,uy) are parallel if they check vx * uy == vy * ux. This means that the
Vectors have the same direction (although they may have different meanings). The public method
ExtremoDesde(Punto org) returns the point where the end of the
vector would be if the origin were placed in org.
* To build the Class 'Recta', it will be taken into account that a straight line is determined by a
vector that marks its direction and a point through which it passes. For this class we
will provide two constructors: the first one that generates the line knowing a point and a directing vector; and the second one that generates the line knowing two points.
* Two lines are parallel if their direction vectors are parallel. A line passes through a point
p if the vector formed by p and a point on the line is parallel to the direction vector of the line.
* Define the method implicita()
which returns a tuple named Implicit with the coefficients a, b and c of the line in
implicit form.
* Use the Cramer rule to calculate the intersection between two lines.
* The public method Recta ParalelaPor(Punto p) returns a line parallel to the
current that passes through the point p. The public method Recta
PerpendicularPor(Point p) returns a line perpendicular to the current one that passes through the
point p. The public method double distanceFrom(Punto p) method must
return the distance between the line and the point passed as a parameter. For this you will have to
create a line perpendicular to the current one that passes through p, calculate the point of intersection of
both lines, and return the distance from this point to p.
* Throughout the exercise, any abnormal situation should cause the
throwing an exception of type RuntimeException.

The EjRectas program calculates the area of ​​a triangle knowing the three points of the plane that
they delimit and then the intersection of two lines.
