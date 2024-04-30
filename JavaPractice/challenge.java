public class challenge {
    public static void main(String[] args){
        System.out.println("Hello World");
        testMethod();
    }

    public static void testMethod(){
        System.out.println("This is a test method");
        
        // declare a string
        String myString = "Hello";
        String myString1 = "Hello";
        
        if (myString == myString1){
            System.out.println("They are equal");
        } else {
            System.out.println("They are not equal");
        }

        String myString2 = new String("Hello");
        String myString3 = new String("Hello");

        if (myString2 == myString3) {
            System.out.println("They are equal");
        } else {
            System.out.println("They are not equal");  // This will be the output.
        }

        // get the memory address of the string
        System.out.println(System.identityHashCode(myString));
        System.out.println(System.identityHashCode(myString1));
        System.out.println(System.identityHashCode(myString2));

    }

}