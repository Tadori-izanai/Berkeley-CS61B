package chap04;

import chap01.Test;

public class WordUtils {
//    public static String longest(SLList<String> list) {
//        int maxIndex = 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).length() > list.get(maxIndex).length()) {
//                maxIndex = i;
//            }
//        }
//        return list.get(maxIndex);
//    }

//    public static String longest(AList<String> list) {
//        int maxIndex = 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).length() > list.get(maxIndex).length()) {
//                maxIndex = i;
//            }
//        }
//        return list.get(maxIndex);
//    }

    public static String longest(List61B<String> list) {
        int maxIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > list.get(maxIndex).length()) {
                maxIndex = i;
            }
        }
        return list.get(maxIndex);
    }


    public static void main(String[] args) {
        testMethod01();
        testMethod02();
    }

    public static void testMethod01() {
        SLList<String> someList = new SLList<>();
        someList.addLast("elk");
        someList.addLast("are");
        someList.addLast("watching");
        System.out.println(longest(someList));
    }

    public static void testMethod02() {
        List61B<String> someList = new SLList<>();
        someList.addFirst("elk");
        someList.addFirst("dwell");
        someList.addFirst("on");
        someList.addFirst("existential");
        someList.addFirst("crises");

//        System.out.println(someList.getFirst());

        someList.print();   // 被 override 前, 调用的是 List61B 中的 print()
                            // print 被 SLList override 后, 调用的是 SLList 中的 print(), 即使 someList 声明的类型是 List61B
    }
}
