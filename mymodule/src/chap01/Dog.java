package chap01;

public class Dog {
//    public static void makeNoise() {
//        System.out.println("Bark!");
//    }

    // 没有 static
    public int weighInPounds;
    public static String binomen = "Canis familiaries";


    // 没有 static
    public void makeNoise() {
        if (weighInPounds < 10)
            System.out.println("yip!");
        else if (weighInPounds < 30)
            System.out.println("bark!");
        else
            System.out.println("woof!");
    }

    // 考虑给一个 constructor
    public Dog(int w) {
        weighInPounds = w;
    }
    public Dog() { }    // 尝试重载


    // 做比较
    // 方法1 static method
    public static Dog maxDog(Dog d1, Dog d2) {
        if (d1.weighInPounds > d2.weighInPounds)
            return d1;
        return d2;
    }
    // 方法2 non-static method
    public Dog heavierDog(Dog d2) {
        if (this.weighInPounds > d2.weighInPounds)  // this.weighInPound 可简化为 weighInPound
            return this;
        return d2;
    }
}
