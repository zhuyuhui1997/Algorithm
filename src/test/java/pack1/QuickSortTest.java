package pack1;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class QuickSortTest {
    private  QuickSort quickSort;
    private int[] arr;
    @Before
    public void init() {
        Random random = new Random();
        quickSort = new QuickSort();
        arr = new int[random.nextInt(1000) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
    }
    @Test
    public void test() {
        for (int i = 0; i < 10000; i++) {
            init();
            int[] temp = arr.clone();
            int[] scr = arr.clone();
            Arrays.sort(temp);
            quickSort.quickSort(arr, 0, arr.length - 1);
            if (!isSame(temp,arr)) {
                System.out.println(Arrays.toString(scr));
                System.out.println(Arrays.toString(temp));
                System.out.println(Arrays.toString(arr));
            }

        }
    }
    public boolean isSame(int[] arr, int[] arr2) {
        if (arr.length != arr2.length)
            return false;
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }


}