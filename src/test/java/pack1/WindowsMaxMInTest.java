package pack1;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class WindowsMaxMInTest {
    WindowsMaxMIn windowsMaxMIn;
    int[] arr;
 /*
 * 初始化数组
 * */
    public void init() {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(10);
        }
        windowsMaxMIn = new WindowsMaxMIn(arr);
    }
    public void test() {
        try{
            Random random = new Random();
            while (windowsMaxMIn.getRight() != arr.length || windowsMaxMIn.getLeft() != arr.length) {
                Boolean flag = random.nextBoolean();
                if (flag) {
                    if (windowsMaxMIn.getRight() < arr.length) {
                        windowsMaxMIn.rightMove();
                    }
                    else if (windowsMaxMIn.getLeft() < windowsMaxMIn.getRight()) {
                        windowsMaxMIn.leftMove();
                    }
                }
                else {
                    if (windowsMaxMIn.getLeft() < windowsMaxMIn.getRight()) {
                        windowsMaxMIn.leftMove();
                    }
                    else if (windowsMaxMIn.getRight() < arr.length) {
                        windowsMaxMIn.rightMove();
                    }
                }
                check();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test1() {
        for (int i = 0; i < 10000; i++) {
            init();
            test();
        }
    }

    /*
    * 使用暴力方法来验证是否满足直接获取最大和最小
    *
    * */
    public void check() throws Exception {
        int[] check = windowsMaxMIn.getWindowArrForCheck();
        Arrays.sort(check);
        if (windowsMaxMIn.getSize() == 0)
            return;
        int max = windowsMaxMIn.getMax();
        int min = windowsMaxMIn.getMin();
        if (max != check[check.length - 1]) {
            System.out.println(windowsMaxMIn);
            System.out.println(max);
            throw new Exception("error");
        }
        if (min != check[0]) {
            System.out.println(windowsMaxMIn);
            System.out.println(min);
            throw new Exception("error");
        }
        System.out.println(windowsMaxMIn);
        System.out.println("Max: " + windowsMaxMIn.getMax());
        System.out.println("Min: " + windowsMaxMIn.getMin());
    }

}