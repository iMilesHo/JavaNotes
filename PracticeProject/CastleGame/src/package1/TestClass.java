package package1;

public class TestClass {
    public static void main(String[] args) {
        Dog dog = new Dog("bai", 25, 1, 3);
        System.out.println(dog.name);
//        System.out.println(dog.weight);
        System.out.println(dog.idCode);
        System.out.println(dog.age);
    }
}

class SheepDog extends Dog {
    public SheepDog(String name, int weight, int idCode, int age) {
        super(name, weight, idCode, age);
        System.out.println(this.name); // public
//        System.out.println(this.weight); // private
        System.out.println(this.idCode); // protected
        System.out.println(this.age); // default
    }
}