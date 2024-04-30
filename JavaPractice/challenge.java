public class challenge {
    public static void main(String[] args){
        System.out.println("Hello World");
        MyClass myObject = new MyClass();
        System.err.println(myObject.instanceVariable);
        System.err.println(MyClass.classVariable);
    }
    

}

class MyClass {
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