package chap03;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
//    public static void testSort() {
//        String[] input = {"i", "have", "an", "egg"};
//        String[] expected = {"an", "egg", "have", "i"};
//        Sort.sort(input);	// 排序
//        // 整体判断
//        if (!java.util.Arrays.equals(input, expected))  // 注意不可以是 (input != expected)
//            System.out.println("Error! There seems to be a problem with Sort.sort().");
//        // 逐个判断
//        for (int i = 0; i < input.length; i++) {
//            if (!input[i].equals(expected[i])) {
//                System.out.println("Mismatch in position " + i + ". expected: " + expected[i] +
//                        ", but got: " + input[i] + ",");
//                break;
//            }
//        }
//    }
//    public static void main(String[] args) {
//        testSort();
//    }

    @Test
    // test 需要 non-static
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);	// 排序
        // 整体判断
        if (!java.util.Arrays.equals(input, expected))  // 注意不可以是 (input != expected)
            System.out.println("Error! There seems to be a problem with Sort.sort().");
        // 逐个判断
        for (int i = 0; i < input.length; i++) {
            if (!input[i].equals(expected[i])) {
                System.out.println("Mismatch in position " + i + ". expected: " + expected[i] +
                        ", but got: " + input[i] + ",");
                break;
            }
        }
    }
}
