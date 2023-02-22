package chap01;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] someArray = new int[5];
        someArray[0] = 3;
        someArray[1] = 4;
        System.out.println(someArray[1]);

        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog(8);
        dogs[1] = new Dog(20);
        for (Dog d : dogs)
            d.makeNoise();
    }
}
