package pack1;

import java.util.Stack;

/*
*
* 非递归 归并排序
*author kl
*
* 从小边多吧
* */
public class MergeSort {

    /*
    * 先排序2个,然后4个,8个
    *
    *
    * */
    public void mergeSort(int[] arr) {
        int low = 0;  //数组起始
        int high = arr.length - 1;  //数组末索引
        int incr = 2;  // 参与单次排序的个数,可能某次达不到
        int index = high -1;  //index索引后面的有序,一个或者有序
        for (int i = incr; i <= arr.length; i *= 2) {
            for (int j = low; j <= high; j += i) {
                //如果当前参与归并排序的个数 == i 个
                if (j + i -1 <= high)
                    merge(arr, j, j + i / 2 -1, j + i - 1);
                //如果参与当前归并排序的个数  < i 个
                else {
                    if (j - 1 == index)  //如果只有一个数参与排序,或者从j开始已经有序
                        continue;
                    else {
                        //由于index后面有序,所以index做 middle ,
                        merge(arr, j, index, high);
                        index = j-1; //从j开始有序
                    }
                }
            }
        }
        merge(arr, 0, index, high);

    }
    public void merge(int[] arr, int left, int middle, int right) {
        if (left >= right)
            return;
        int[] temp = new int[right - left + 1];
        int index = 0;
        int index_1 = left;
        int index_2 = middle + 1;
        while (index_1 <= middle && index_2 <= right) {
            if (arr[index_1] > arr[index_2])
                temp[index++] = arr[index_2++];
            else
                temp[index++] = arr[index_1++]; //相等左边先进

        }
        while (index_1 <= middle)
            temp[index++] = arr[index_1++];
        while (index_2 <= right)
            temp[index++] = arr[index_2++];
        System.arraycopy(temp, 0, arr, left, temp.length);
        temp = null;
    }

}

