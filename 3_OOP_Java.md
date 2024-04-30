# Object-oriented programming (OOP) on Java

## Classes and Objects

1. **Classes**: A class is a blueprint or template for creating objects. It defines the structure and behavior of objects. In Java, classes are defined using the `class` keyword.

   ```java
   public class Car {
       // Fields (attributes)
       String make;
       String model;
       int year;

       // Methods (behavior)
       void start() {
           System.out.println("The car is starting.");
       }

       void drive() {
           System.out.println("The car is driving.");
       }
   }
   ```

2. **Objects**: An object is an instance of a class. It represents a real-world entity and has state (attributes) and behavior (methods). You can create objects from a class using the `new` keyword.

   ```java
   public class Main {
       public static void main(String[] args) {
           // Create an object of the Car class
           Car myCar = new Car();

           // Set the object's attributes
           myCar.make = "Toyota";
           myCar.model = "Corolla";
           myCar.year = 2020;

           // Call the object's methods
           myCar.start();
           myCar.drive();
       }
   }
   ```

3. What is the difference of the local variables and the object's attributes?

   - **Local variables**: Variables declared inside a method or block are called local variables. They are only accessible within that method or block.
   - **Object's attributes**: Attributes (fields) are variables declared within a class. They represent the state of an object and are accessible throughout the class.
   - lifespan:
     - Local variables: Created when the method is called and destroyed when the method completes.
     - Object's attributes: Created when the object is created and destroyed when the object is garbage collected.

## Objects accessibilities

1. What is encapsulation?

   - **Encapsulation**: Encapsulation is the process of bundling the data (attributes) and methods (behavior) that operate on the data into a single unit called a class. It helps in hiding the internal state of an object and restricting access to it.
   - **Access modifiers**: Java provides four access modifiers to control the visibility of classes, fields, methods, and constructors:
     - `public`: Accessible from any other class.
     - `protected`: Accessible within the same package and subclasses.
     - `default` (no modifier): Accessible within the same package.
     - `private`: Accessible only within the same class.

1.1 class accessibilities in Java

- **Public class**: A public class can be accessed from any other class.
- **Default class**: A default class can only be accessed within the same package.

2. What is the function of the `static` keyword?
