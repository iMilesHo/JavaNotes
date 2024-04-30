package package2;

import package1.Dog;

public class Cat {
    private String name;
    private int age;
    private Dog dog = new Dog(3, "bai");

    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat.dog.name);
    }
}
