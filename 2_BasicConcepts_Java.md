# Basic Concepts of Java

## word explanation

- RAM: Random Access Memory, a type of computer memory that can be accessed randomly, meaning any byte of memory can be accessed without touching the preceding bytes.
- primitive data types: basic data types provided by Java, such as int, float, double, char, boolean, byte, short, and long.
- expression: a combination of variables, operators, and method calls that evaluates to a single value.
- statement: a complete unit of execution that can include one or more expressions.
- keyword: a reserved word that has a specific meaning and cannot be used for other purposes in the language.
- identifier: a name given to a variable, method, class, or package
- variable: a container that holds data that can be changed during the execution of a program.
- code block: a group of statements enclosed in curly braces `{}`.
- whitespace: any sequence of one or more spaces, tabs, or line breaks. Whitespace is used to separate tokens in a program and is generally ignored by the compiler.

### Keywords

Java have a set of keywords that are reserved words that cannot be used as identifiers. These keywords are used to define the syntax and structure of Java code. Here are some of the most commonly used keywords in Java:

int, float, double, char, boolean, byte, short, long, void, class, interface, extends, implements, package, import, new, this, super, static, final, abstract, public, protected, private, if, else, switch, case, default, while, do, for, break, continue, return, true, false, null

### method: reduce the code duplication and make the code reusable.

- parameters or arguments: a parameter is the definition in the method declaration. An argument is the actual value that is passed when the method is invoked.
- procedure: method that does not return a value.
- Metheod signature: the parameters (return value is not supported).
- Java do not support method overloading by return type.
- Java do not sopport default parameters value.

### #How to compare code using IntelliJ IDEA

You can just click the code file using the right button of the mouse, and then click the `Compare with` option, and then click the `path` option to compare the code.

### check the history of the code

Also, you can use the right button of the mouse to click the code file, and then click the `Local History` option to check the history of the code.

## Calculation

1. What is the difference between compiled programming languages and interpreted programming languages?

- how their code is executed on a computer, which affects both the development process and the performance
- Compiled programming Languages:
  - compilation process: source code -> machine code through a compiler, one time process, -> a binary file or executable file
  - execution speed: directly executed by the computer's CPU, so it is generally faster than interpreted languages
  - Examples: C, C++, Rust, Go
  - platform specific: compile sperately for different platforms
  - Error checking: compile-time error checking, which can catch errors before the program is run
- Interpreted programming Languages:
  - interpretation process: source code -> executed directly by an interpreter, line by line
  - Execution speed: tend to be slower than compiled languages, as the interpreion needs to happen every time the program is run
  - Examples: Python, Ruby, JavaScript
  - platform independent: run on any platform that has the interpreter installed
  - Error checking: errors are typically caught at runtime, which means certain types of bugs can be harder to catch
- Hybrid languages (Just-in-time compilation):
  - Examples: Java, C#
  - a combination of both, balance development speed (cross-platform) and execution speed
  - compilation process: source code -> bytecode through a compiler, -> bytecode is executed by a virtual machine (JVM or CLR), which can be interpreted or compiled to machine code at runtime
  - Execution speed: faster than pure interpreted languages, but slower than pure compiled languages
  - platform independent: run on any platform that has the virtual machine installed
- Analysis of Just-in-time compilation:
  - How it works:
    - Bytecode Generation: source code -> bytecode, intermediate representation, higher-level than machine code but designed to be efficiently executed by the virtual machine
    - Runtime Compilation: instead of interpreting the bytecode line-by-line every time a program runs, JIT compilers compile the bytecode into native machine code at runtime. And this convertion happens the first time a code path is executed and typically caches the resulting machine code for future use.
    - Dynamic Optimization: JIT compilation occurs during execution, it can optimize performance dynamically based on the actual runtime data. For example, it can optimize frequently executed code paths more aggressively, a process known as "hotspot optimization".
    - Memory and Startup Impact: faster than pure interpreted languages, though increase memory usage and startup time, since compilation occurs during execution, there can be a delay before parts of the application reach their peak performance.
  - Advantages:
    - Platform Independence: platform-independent until runtime, simplifying the development process and deployment process for cross-platform applications
    - Performance: combine the speed of compiled languages with the flexibility of interpreted languages, once the bytecode is compiled to machine code, it can be executed as fast as a compiled language
    - Adaptive Optimization: JIT compilers can perform optimizations that are not possible at compile time, such as inlining functions based on the run-time profile of the application
  - Challenges:
    - complexity: JIT compiler is complex, requiring maintain
    - initial performance penalty: there can be a "warm-up" time where the JIT compiler is still processing parts of the bytecode
    - resource usage: JIT compilation can consume more memory and CPU resources than pure interpretation

2. What is the difference between = and == in Java?

- `=`: assignment operator, used to assign a value to a variable
- `==`: equality operator, used to compare two values for equality
  - primitive data types: actual values are compared
  - reference data types: memory addresses are compared, not the actual values
  - Note: `equals()` method should be used to compare the actual values of objects
  - String has internal pool for the literal strings, so `==` can be used to compare the string literals (interning mechanism). But for the string objects created using `new` keyword, `==` should not be used.

3. How to debug compilation errors in Java?

- Read the error messages: compiler provides file name, line number, and a description of the error
- check for common mistakes
  - syntax errors: missing semicolons, parentheses, curly braces, etc.
  - typos: misspelled keywords, variable names, method names, etc.
  - type errors
  - scope errors: variables out of scope
  - case sensitivity: Java is case-sensitive
- comment out code: isolate the recent changes or suspicious code
- ensure the API usage is correct
- compile often: fix errors as soon as they appear
- use online resources: search for the error message online
- learn from the error

4. Symbol "/" for integer and floating-point division in Java?

- integer division: the fractional part is truncated and discarded
- floating-point division: the result is a floating-point number with the fractional part

```java
int res = 5 / 2;
// 2

double res2 = 5 / 2;
// 2.0

double res3 = (double) 5 / 2;
// 2.5

double res4 = 5 / 2.0;
// 2.5

int res5 = 5.0 / 2;
// error - incompatible types: possible lossy conversion from double to int
```

5. Casting in Java?

- double to int: truncates the fractional part
- int to double: adds a fractional part of 0

```java
double d = 3.14;
int i = (int) d;
// 3

int i2 = 5;
double d2 = i2;
// 5.0
```

6. rounding and taking remainders in Java?

- rounding
  - Math.round(): rounds to the nearest integer
  - Math.floor(): rounds down to the nearest integer
  - Math.ceil(): rounds up to the nearest integer
  - Math.rint(): bank rounding
- remainders
  - %: remainder operator, returns the remainder of the division

7. difference between `++i` and `i++`?

- `++i`: pre-increment, increments the value of `i` and then returns the new value
- `i++`: post-increment, returns the current value of `i` and then increments the value

## flow control

1. when should we use a if-else statement and when should we use a switch statement?

- if-else statement:
  - complex conditions: any types of booleean expressions, equality, relational, logical, etc.
  - value comparison: when the conditions are not based on a single value
  - Non-discrete values: when the conditions are not based on a single value
  - few conditions: when there are only a few conditions to check
- switch statement:
  - multiple cases on the same variable: on a list of discrete values
  - readability and organization
  - performance: for a large number of cases, switch is more efficient (jump table)
  - enum and constant

```java
char grade = 'B';
switch (grade) {
    case 'A':
        System.out.println("Excellent");
        break;
    case 'B':
        System.out.println("Very Good");
        break;
    case 'C':
        System.out.println("Good");
        break;
    default:
        System.out.println("Needs Improvement");
        break;
}
```

## loop

1. while and for loop in Java?

- while loop: used when the number of iterations is not known in advance
- for loop: used when the number of iterations is known in advance

```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}

for (int j = 0; j < 5; j++) {
    System.out.println(j);
}
```

2. short-circuit evaluation in Java?

- AND (`&&`): if the first condition is false, the second condition is not evaluated
- OR (`||`): if the first condition is true, the second condition is not evaluated

```java
int x = 0;
if (x != 0 && 10 / x > 1) {
    // This block will not execute
}

int y = 10;
if (y > 0 || y > 100) {
    // This block will execute
}
```

- performance optimization: skip unnecessary evaluations
- avoid exceptions: prevent division by zero, null pointer exceptions, etc.

## Array

1. Do the elements of an array have to be the same size in java?

- No, not necessarily. Java supports arrays of different sizes, such as jagged arrays or arrays of arrays.
- array of primitives: same size
- array of objects: same size
- array of arrays: can be different sizes (jagged arrays)

```java
int[][] jaggedArray = new int[3][];
jaggedArray[0] = new int[] {1, 2};
jaggedArray[1] = new int[] {3, ,4, 5};
jaggedArray[2] = new int[] {6};

for (int i = 0; i < jaggedArray.length; i++) {
    for (int j = 0; j < jaggedArray[i].length; j++) {
        System.out.print(jaggedArray[i][j] + " ");
    }
    System.out.println();  // New line for each row
}
```

2. Is the data stored contiguously in memory in Java?

- Arrays and ArrayLists store data contiguously in memory
- Objects and more complex or linked data structures (like LinkedLists and HashMaps) do not store data contiguously beyond the individual element or object level, which can affect traversal and access patterns.

3. How to initialize an array in Java?

- initialize an array with default values

```java
int[] arr = new int[5]; // all set to 0
```

- initialize an array with specific values

```java
int[] arr = {1, 2, 3, 4, 5};
```

- Initializing Arrays with a Loop

```java
int[] arr = new int[5];
for (int i = 0; i < arr.length; i++) {
    arr[i] = i + 1;
}
```

- Initializing Multidimensional Arrays

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
}; // A 3x3 matrix

int[][] matrix2 = new int[3][3];
for (int i = 0; i < matrix2.length; i++) {
    for (int j = 0; j < matrix2[i].length; j++) {
        matrix2[i][j] = i * 3 + j + 1;
    }
}
```

- Using Arrays.fill() method

```java
int[] arr = new int[5];
Arrays.fill(arr, 10); // Fill the array with 10
```

4. how to traverse an array in Java?

```java
int[] arr = {1, 2, 3, 4, 5};

// for loop
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

// for-each loop
for (int num : arr) {
    System.out.println(num);
}

// or use do while loop and while loop
```

5. Memory layout of an 2D array in Java?

- Java do not allocate memory for the 2D array in a single contiguous block
- 2D array is an array of references to arrays
- each reference points to a separate object in Java's heap memory
- each row can have a different length
- Implications:
  - memory fragmentation: need more time to access the elements
  - cache locality: less efficient cache usage
- Alternative
  - use a single-dimensional array to simulate a 2D array
  - use libraries like Apache Commons Math or JAMA

6. Memory Management about the array in Java?

- Cache locality
  - the data loaded into the cache by the CPU
  - Modern CPU use a cache, a small, fast storage layer the stores copies of frequently accessed memory locations
  - Temporal locality: a recently accessed memory location is likely to be accessed again soon
  - Spatial locality: a memory location near a recently accessed location is likely to be accessed soon
- Implications of Cache Locality
  - Non-contiguous data structures: like linked lists, trees, and hash maps, can lead to poor cache performance
  - Contiguous data structures: like arrays and ArrayLists, can lead to better cache performance
- Memory Overhead: additional memory used by the JVM to manage objects
  - Objects header: class metadata, garbage collection information, etc.
  - Padding: memory alignment for efficient access (8-byte boundary)
  - Pointer References: additional memory for references to objects
- Implications of Memory Overhead
  - Small objects: if many small objects are used, triple the memory overhead
  - Garbage Collection: more objects, more memory to manage
- Tips:
  - use 1D array or ArrayList for better cache performance
  - be wary of using many small objects
  - reuse objects when possible (object pooling)
  - custom memory management (rarely needed): ByteBuffer

7. how to traverse a 2D array in Java?

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
}

for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();  // New line for each row
}

// or use for-each loop
for (int[] row : matrix) {
    for (int num : row) {
        System.out.print(num + " ");
    }
    System.out.println(); // New line for each row
}
```

## Objects

1. difference between a unicode and ascii?

- ASCII: American Standard Code for Information Interchange(1963)
  - 7-bit encoding scheme: 128 characters (0-127)
  - Originally designed for English, limited to 128 characters
  - Extended ASCII: 8-bit encoding scheme, 256 characters (0-255)
  - Limited character set for English and other Western European languages
- Unicode: universal character encoding standard
  - 16-bit encoding scheme: 65,536 characters (0-65,535)
  - Supports multiple languages, symbols, and emojis
  - UTF-8: variable-length encoding, 1-4 bytes per character
  - UTF-16: fixed-length encoding, 2 bytes per character
  - UTF-32: fixed-length encoding, 4 bytes per character
  - ASCII is a subset of Unicode

2. What is the function of the wrapper classes in Java?

- For primitive data types
  - leverage the power of objects in Java
  - each primitive data type has a corresponding wrapper class
    - int: Integer, Char: Character, the rest ones are with the first letter capitalized
  - provide utility methods and constants
- Collections
  - Java Collections Framework: a set of classes and interfaces that implement commonly used data structures
  - Collections require objects, not primitives
  - Autoboxing: automatic conversion between primitive data types and their corresponding wrapper classes
- Utility methods
  - parsing: converting strings to primitive data types
  - conversion: converting between primitive data types
  - arithmetic: performing mathematical operations
  - constants: MIN_VALUE, MAX_VALUE, etc.

```Java
// Autoboxing and Unboxing
Integer refInteger = 100; // Autoboxing of int to Integer
int num = refInteger; // Unboxing of Integer to int

// Utility methods
int num1 = Integer.parseInt("123"); // Convert string to int
String str = Integer.toString(123); // Convert int to string
```

3. string compareTo() method in Java?

- `compareTo()`: compares two strings lexicographically
  - returns a negative integer, zero, or a positive integer as the first string is less than, equal to, or greater than the second string
  - case-sensitive comparison
  - based on the Unicode value of each character
  - useful for sorting strings

```java
String str1 = "apple";
String str2 = "banana";

int result = str1.compareTo(str2);
// -1
```

4. string equals() method in Java?

- `equals()`: compares the content of two strings
  - returns true if the strings have the same content, false otherwise
  - case-sensitive comparison
  - based on the Unicode value of each character

```java
String str1 = "apple";
String str2 = "apple";

boolean result = str1.equals(str2);
// true
```

5. string indexOf() method in Java?

- `indexOf()`: returns the index of the first occurrence of a specified character or substring in a string
  - returns -1 if the character or substring is not found
  - can specify the starting index for the search

```java
String str = "hello world";

int index = str.indexOf('0');
// 4
```

## Functions

1. void return type in Java?

- `void`: return type that indicates the method does not return a value
- used for methods that perform an action but do not return a value
- the method can still have side effects, such as modifying the state of an object or printing output

2. what will happen if the parameters passed do not match the method signature in Java?

- compile-time error: the compiler will check the number of parameters, their types, and their order
  - missing parameters: error
  - extra parameters: error
  - wrong types: error
  - wrong order: error
  - ambiguity: error

3. What is the lifespan and scope of local variables?

- variables cannot be declared outside of any class scope
- local variables: declared inside a method or block, only accessible within that method or block
- class variables: declared inside a class but outside a method, accessible to all methods in the class.
- instance variables: declared inside a class but outside a method, each object has its own copy

```java
public class MyClass {
    static int classVariable; // Static field, shared among all instances

    int instanceVariable; // Instance field, each object has its own copy

    void myMethod(int parameter) { // parameter is an argument passed to the method
        int localVariable = 0; // Local variable, exists only within this method

        try {
            // Some code that might throw an exception
        } catch (Exception e) { // Exception handler parameter, local to this catch block
            int catchVariable = 1; // Local to this catch block
        }
    }
}
```

- Initialization:
  - local variables: must be initialized before use
  - class and instance variables: initialized to default values if not explicitly initialized
    - Example: int: 0, boolean: false, reference types: null

4. What is a function declaration? What is a function definition?

- function declaration: specifies the function's name, return type, and parameters
- function definition: provides the implementation of the function

```java
public interface MathOperations {
    int multiply(int a, int b);  // Declaration without definition
}

public class SimpleMath implements MathOperations {
    @Override
    public int multiply(int a, int b) {  // Declaration with definition
        return a * b;
    }
}
```

5. primtiive data types in Java?

- int: 32-bit signed integer
- float: 32-bit floating-point number
- double: 64-bit floating-point number
- char: 16-bit Unicode character
- boolean: true or false, 1 bit
- byte: 8-bit signed integer
- short: 16-bit signed integer
- long: 64-bit signed integer

6. When is a function parameter passed as a value and when is it passed as a pointer?

- Java passes arguments by value, which means a copy of the argument is passed to the method
- primitive data types: passed by value
- objects reference: passed by value, but the reference points to the same object in memory

```java
public void modifyData(ArrayList<Integer> list) {
    list.add(10);
}

ArrayList<Integer> myList = new ArrayList<>();
modifyDta(myList);
System.out.println(myList); // [10]
```

- Clarifying Misconceptions: References Passed by Value
  - we cannot modify the original reference itself to point to a different object

```java
public void changeReference(ArrayList<Integer> list) {
    list = new ArrayList<>(); // This changes only the local copy of the reference
    list.add(200);
}

ArrayList<Integer> myList = new ArrayList<>();
changeReference(myList);
System.out.println(myList); // myList will still be empty, not [200]
```

# Reference

- Google java style guide: https://google.github.io/styleguide/javaguide.html#s4.6-whitespace

```

```
