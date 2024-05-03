package package2;

import package1.Dog;

public class Host {
    public static void main(String[] args) {
        Dog dog = new Dog("bai", 25, 1, 3);
        System.out.println(dog.name);
//        System.out.println(dog.weight);
//        System.out.println(dog.idCode);
//        System.out.println(dog.age);
    }
}

class Huskie extends Dog {

    public Huskie(String name, int weight, int idCode, int age) {
        super(name, weight, idCode, age);
        System.out.println(this.name); // public
//        System.out.println(this.weight); // private
        System.out.println(this.idCode); // protected
//        System.out.println(this.age); // default
    }
}