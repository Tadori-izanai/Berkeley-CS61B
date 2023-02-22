package disc04;

public class TestAnimal {
    public static void main(String[] args) {
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        Dog d = new Dog("Fido", 4);

        a.greet();            // Animal Pluto says: Huh?
        c.greet();            // Cat Garfield says: Meow!
        d.greet();            // Dog Fido says: Woof!
        c.play();             // Woo it is so much fun being an animal!
        c.play(":)");         // Woo it is so much fun being a cat!:)
        a = c;                // -> n/a
        ((Cat) a).greet();    // Cat Garfield says: Meow!
        ((Cat) a).play(":D");     // Woo it is so much fun being a cat!:D
//        a.play(14);           // -> compile-time error
//        ((Dog) a).play(12);   // -> runtime error (
        a.greet();            // -> Cat Garfield says: Meow!
//        c = a;                // -> compile-time error
        c = (Cat) a;
    }
}
