package pack1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class MergeSortTest {
    private  MergeSort mergeSort;
    private  int[] arr;

    public void init() {
        Random random = new Random();
        mergeSort = new MergeSort();
        arr = new int[random.nextInt(20) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
    }
    @Test
    public void test() {
        for (int i = 0; i < 10000; i++) {
            init();
            int[] temp = arr.clone(); // 原数组的拷贝,给系统排序,
            int[] scr = arr.clone();  //原数组的拷贝
            Arrays.sort(temp);  //系统排序temp
            mergeSort.mergeSort(arr); //算法排序
            if (!isSame(temp,arr)) {
                System.out.println("原数组: " + Arrays.toString(scr));
                System.out.println("系统排序后数组: " + Arrays.toString(temp));
                System.out.println("手动算法排序后数组: " + Arrays.toString(arr) + "\n");
            }

        }
    }

    @Test
    public  void test2() {
        mergeSort = new MergeSort();
        arr = new int[]{6, 8, 8, 7};
        mergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
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