package package3;

public class TestStatic {

    public static void main(String[] args) {
        Fish fish = new Fish();
        System.out.println(Fish.weight);
        System.out.println(fish.weight);
        
        fish.greeting();
        Fish.greeting();
    }

}

class Fish {
    static int weight;

    static void greeting() {
        System.out.println("Hello World!");
    }
}