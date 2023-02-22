package chap01;

public class DogLoop {
    public static void main(String[] args) {
        Dog smallDog = new Dog(5);
        Dog mediumDog = new Dog(25);
        Dog hugeDog = new Dog(150);

        Dog[] manyDogs = new Dog[4];
        manyDogs[0] = smallDog;             // 5
        manyDogs[1] = hugeDog;              // 150
        manyDogs[2] = new Dog(130);     // 130

        int i = 0;
        // <10 yip, <30 bark, >=30 woof
        while (i < manyDogs.length) {
            Dog.maxDog(manyDogs[i], mediumDog).makeNoise();
            i++;
        }   // 此循环会遍历到 manyDogs[3], 运行到第 4 轮的时候报错: NullPointerException
        // 程序中途推出: Process finished with exit code 1
    }
}
