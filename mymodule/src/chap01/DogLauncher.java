package chap01;

public class DogLauncher {
//    public static void main(String[] args) {
//        Dog.makeNoise();
//    }

    public static void main(String[] args) {
        Dog d;
        d = new Dog();
        d.weighInPounds = 20;
        d.makeNoise();


        Dog d2 = new Dog(51);
        d2.makeNoise();
    }
}
