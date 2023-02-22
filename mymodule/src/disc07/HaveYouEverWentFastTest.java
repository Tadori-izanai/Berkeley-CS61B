package disc07;


import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Arrays;

import static disc07.HaveYouEverWentFast.*;
import static org.junit.Assert.assertEquals;

public class HaveYouEverWentFastTest {
    @Test
    public void test() {
        int tries = 10000;
        for (int k = 0; k < tries; k++) {
            int size = StdRandom.uniform(1, 10);
            int tmp = StdRandom.uniform(0, 5);
            int[] a = new int[size];

            for (int i = 0; i < size; i++) {
                a[i] = tmp;
                tmp += StdRandom.uniform(1, 4);
            }

            int x = StdRandom.uniform(5, 25);
            assertEquals(findSum(a, x), findSumNSquare(a, x));

//            System.out.println(Arrays.toString(a));
//            System.out.println(x);
        }
    }
}
