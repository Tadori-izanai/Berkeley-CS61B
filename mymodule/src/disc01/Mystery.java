package disc01;

import java.util.Arrays;

public class Mystery {
    public static void main(String[] args) {
        int[] iArray = new int[] {3, 0, 4, 6, 3};
        System.out.println(Arrays.toString(iArray));    // 将 int 数组转化为字符串, 然后输出
        mystery2(iArray);
        System.out.println(Arrays.toString(iArray));
    }


    /**
     * @param inputArray 输入的数组
     * @param k 下标 k
     * @return 数组 inputArray 中, 下标 k 以后的元素中, 最小元素对应的下标
     */
    public static int mystery(int[] inputArray, int k) {
        int x = inputArray[k];
        int answer = k;
        for (int index = k + 1; index < inputArray.length; index++) {
            if (inputArray[index] < x) {
                x = inputArray[index] ;
                answer = index;
            }
        }
        return answer;
    }


    /**
     * 升序排序 inputArray (采用选择排序)
     * @param inputArray 待排序的数组
     */
    public static void mystery2(int[] inputArray) {
        for (int index = 0; index < inputArray.length; index++) {
            int targetIndex = mystery(inputArray, index);   // 找到 index 之后的元素中, 最小元素对应的下标
            // 交换 index targetIndex
            int temp;
            temp = inputArray[targetIndex];
            inputArray[targetIndex] = inputArray[index];
            inputArray[index] = temp;
        }
    }
}
