When you install Java 17 JDK (Java Development Kit) on your computer, you're essentially equipping it with everything you need to develop and run Java applications. Here's a breakdown of the terms you mentioned and their relationships:

1. **Java**: This is a general term that refers to the Java programming language itself. It's a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.

2. **JVM (Java Virtual Machine)**: The JVM is an engine that provides a runtime environment to drive the Java Code (bytecode). Every Java application runs inside a JVM. The JVM is responsible for converting bytecode into machine-specific code. It's platform-independent, meaning Java programs can run on any device that has a JVM.

3. **JRE (Java Runtime Environment)**: The JRE includes the JVM, code libraries, and components that are necessary for running programs written in the Java programming language. It does not contain tools and utilities such as compilers or debuggers for developing applets and applications. 

4. **JDK (Java Development Kit)**: The JDK is a superset of the JRE. It contains everything that is in the JRE, plus tools such as the compilers and debuggers necessary for developing Java applications. The JDK allows you to compile and package your Java code into applications that can run on the Java platform.

**Inclusion Relationship**: 
- JDK > JRE > JVM
- The JDK includes the JRE, which in turn includes the JVM. When you install the JDK, you don't need to separately install the JVM or JRE because the JDK installation package already includes them.

**What else should you install?**
- **IDE (Integrated Development Environment)**: While not a requirement, using an IDE can significantly enhance your productivity. Popular Java IDEs include IntelliJ IDEA, Eclipse, and NetBeans. They provide features like code completion, debugging, and version control.
- **Build Tools**: Depending on your project's complexity, you might also consider installing build tools like Maven or Gradle. These tools help manage dependencies, build processes, and testing.

Once you've installed the JDK, you're pretty much set to start developing Java applications. You can begin writing Java code using a simple text editor and compile it using the JDK's `javac` compiler. However, for a more efficient development process, installing an IDE is highly recommended.