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

  1.2 Attributes accessibilities in Java

- **Public attribute**: can be accessed from any other class including subclasses.
- **Protected attribute**: can be accessed within the same package and any subclasses (even if they are in a different package).
- **Default attribute**: can be accessed only within the same package
- **Private attribute**: can be accessed only within the same class.

  1.3 accessibilities when overriding and overloading on attributes in Java

- Attributes: Java does not support overriding for attributes. The attribute will be hidden or shadowed if a subclass declares an attribute with the same name as the superclass.
- use the `super` keyword to access the superclass attribute.
- use the `this` keyword to access the subclass attribute

  1.4 Methods accessibilities in Java obey the same rules as attributes.

2. What is the function of the `static` keyword?

- static variables: a class-level variable that is shared among all instances of the class.
  - Can be accessed using the class name or object reference.
  - Memory is allocated only once when the class is loaded.
- static methods: a class-level method that belongs to the class rather than an object.
  - Can be called using the class name.
  - Cannot access instance variables directly.
- static blocks: a block of code that is executed when the class is loaded into memory.
  - Used to initialize static variables.
  - Executed only once when the class is loaded.
- static nested classes: a nested class that is declared as static.
  - Can access static members of the outer class.
  - Cannot access non-static members of the outer class directly.
  - only nested classes can be declared as static.

```java
// Example of static variable
public class Car {
    private static int numberOfCars = 0;

    public Car() {
        numberOfCars++;
    }

    public static int getNumberOfCars() {
        return numberOfCars;
    }
}

public class Test {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        System.out.println("Total number of cars: " + Car.getNumberOfCars());
    }
}

// Example of static method
public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }
}

public class Test {
    public static void main(String[] args) {
        int sum = MathUtils.add(5, 10);
        int product = MathUtils.multiply(4, 3);
        System.out.println("Sum: " + sum + ", Product: " + product);
    }
}

// Example of static block
public class Configuration {
    private static Properties config;

    static {
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            config = new Properties();
            config.load(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    public static String getProperty(String key) {
        return config.getProperty(key);
    }
}

public class Test {
    public static void main(String[] args) {
        String dbUrl = Configuration.getProperty("databaseUrl");
        System.out.println("Database URL: " + dbUrl);
    }
}

// Example of static nested class
public class LinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
}

public class Test {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
    }
}
```

## abstractions and interfaces

1. what is the difference between abstract classes and interfaces in Java?

- **Abstract class**: A class that cannot be instantiated and may contain abstract methods (methods without a body). It can have both abstract and concrete methods. An abstract class can also have fields, constructors, and non-abstract methods.
  - Use the `abstract` keyword to declare an abstract class.
  - Abstract classes can have constructors.
  - An abstract class can have fields, constructors, and non-abstract methods.
  - A class can extend only one abstract class.
  - An abstract class can implement interfaces.
  - used when you want to provide a common base implementation for subclasses.

```java
public abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public void printDetails() {
        System.out.println("Color: " + color);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }
}
```

- **Interface**: A reference type in Java that contains only abstract methods (methods without a body) and constants. It provides a way to achieve abstraction and multiple inheritance in Java. An interface cannot have fields, constructors, or non-abstract methods.
  - Use the `interface` keyword to declare an interface.
  - Interfaces can have constants (static final fields).
  - A class can implement multiple interfaces.
  - All methods in an interface are implicitly `public` and `abstract`.
  - used when you want to define a contract for classes to implement.

```java
public interface Shape {
    double getArea();
    double getPerimeter();
}

public interface Drawable {
    void draw();
}

public class Circle implements Shape, Drawable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Rectangle implements Shape, Drawable {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}
```

2. What is the difference between the `private, `default`and`static` methods in interfaces?

- **Default method**: A method in an interface that provides a default implementation. It allows you to add new methods to an existing interface without breaking the classes that implement the interface.
  - Use the `default` keyword to declare a default method.
  - Default methods can be overridden by classes that implement the interface.
  - Default methods can call other methods in the same interface.
- **Static method**: A method in an interface that is associated with the interface itself, not with any instance of the interface. It can be called using the interface name.
  - Use the `static` keyword to declare a static method.
  - Static methods cannot be overridden by implementing classes.
  - Static methods can only call other static methods in the same interface.
- **Private method**: A method in an interface that is not visible to implementing classes. It is used to break down the code into smaller reusable components.
  - Use the `private` keyword to declare a private method.
  - Private methods cannot be overridden by implementing classes.
  - Private methods can only be called from other methods in the same interface.

```java
public interface Shape {
    double getArea();
    double getPerimeter();

    private void printMessage(String message) {
        System.out.println(message);
    }

    default void printDetails() {
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        printMessage("This is a shape interface");
    }

    static void printInfo() {
        System.out.println("This is a shape interface");
    }
}

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.printDetails();
        Shape.printInfo();
    }
}
```

3. What is the difference between the `interface` and `inheritance` in Java?

- **Inheritance**: A mechanism in Java that allows one class to inherit properties and behavior from another class. It establishes an `is-a` relationship between classes.
  - A class can inherit
    - Fields (attributes)
    - Methods (behavior)
    - Constructors
  - A class can inherit from only one superclass (single inheritance).
  - Used to promote code reuse and establish a hierarchy between classes.
- **Interface**: A reference type in Java that contains only abstract methods and constants. It establishes a `has-a` relationship between classes.
  - An interface can be implemented by multiple classes.
  - A class can implement multiple interfaces.
  - Used to achieve abstraction and define a contract for classes to implement.
  - Used to enhance the robustness of the code by providing multiple inheritance.

# Inversion of Control (IoC) and the Model-View-Controller (MVC) pattern in Java

1. What is Inversion of Control (IoC) in Java?

- **Inversion of Control (IoC)**: A design principle in software engineering where the control of object creation and lifecycle is inverted from the application to a framework or container. It allows the framework to manage the dependencies between objects and provide them when needed.
  - IoC is achieved through
    - Dependency Injection (DI): A technique where the dependencies of an object are provided externally rather than created internally.
      - Constructor Injection: Dependencies are passed through the constructor.
      - Setter Injection: Dependencies are set using setter methods.
      - Field Injection: Dependencies are injected directly into fields.
      - Interface Injection: Dependencies are injected through an interface.
    - Dependency Lookup: A technique where an object looks up its dependencies from a container or registry.
  - IoC containers (e.g., Spring, Guice) are used to manage the lifecycle of objects and their dependencies.
  - IoC promotes loose coupling between objects and makes the code more modular and testable.
- Model-View-Controller (MVC) pattern: A design pattern that separates an application into three main components: Model, View, and Controller. It helps in organizing the code, improving maintainability, and promoting reusability.
  - **Model**: Represents the data and business logic of the application. It interacts with the database, processes data, and contains the application's core logic.
  - **View**: Represents the user interface of the application. It displays the data to the user and captures user input. It is responsible for presenting the data in a user-friendly format.
  - **Controller**: Acts as an intermediary between the Model and View. It processes user input, updates the Model, and updates the View based on the Model's state. It contains the application's control logic.
- In Java Web applications,
  - The Model is typically represented by JavaBeans, objects with getter/setter methods., and service classes which contain the business logic.
  - The View is represented by JSP (JavaServer Pages) or HTML templates that display the data to the user.
  - The Controller would be a Servlet or a Spring Controller that handles user requests, interacts with the Model, and updates the View.

Example in a Java Web Application Using Spring MVC:

```java
// Model
public class User {
    private String name;
    private int age;

    // Constructor, getters, and setters
}

// Controller
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ModelAndView showUser() {
        User user = userService.getUser();
        ModelAndView mav = new ModelAndView("userView");
        mav.addObject("user", user);
        return mav;
    }
}

// UserService - part of the model handling business logic
@Service
public class UserService {
    public User getUser() {
        return new User("John Doe", 25); // Typically, data would be fetched from a database
    }
}

// userView.jsp - View (JSP file)
<html>
<body>
    <h1>User Information</h1>
    <p>Name: ${user.name}</p>
    <p>Age: ${user.age}</p>
</body>
</html>

```

# Exception Handling in Java

1. How does catch match exceptions?

2.
