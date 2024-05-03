package package3;

public class TestInheritanceClass {
    public static void main(String[] args) {
        Subclass obj = new Subclass();
        obj.printNumber(); // Prints 20 followed by 10
        obj.greeting();

        Superclass obj2 = new Subclass();
        System.out.println(obj2.num); // Prints 10 because the reference type of obj2 is Superclass
        obj2.greeting();
    }
}

class Superclass {
    int num = 10;

    void greeting() {
        System.out.println("This is superclass");
    }
}

class Subclass extends Superclass {
    int num = 20;

    void printNumber() {
        System.out.println(num); // Accesses the subclass's num
        System.out.println(super.num); // Accesses the superclass's num using 'super'
    }

    void greeting() {
        System.out.println("This is subclass");
    }
}