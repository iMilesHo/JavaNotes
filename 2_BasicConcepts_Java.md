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

# Reference

- Google java style guide: https://google.github.io/styleguide/javaguide.html#s4.6-whitespace
