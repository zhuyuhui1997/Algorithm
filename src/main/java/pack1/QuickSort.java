package pack1;


import java.util.Stack;

/*
* 非递归快排
* NoRecurQuickSort
*author kl
*
* */
public class QuickSort {

    /*
    * 分区快排 模型
    *
    * */
    public int[] partition(int[] arr, int left, int right) {
        int key = arr[left];
        int cur = left;
        while (cur <= right) {
            if (arr[cur] == key) {
                cur++;
            }
            else if (arr[cur] > key) {
                int temp = arr[cur];
                arr[cur] = arr[right];
                arr[right] = temp;
                right--;
            }
            else {
                int temp = arr[cur];
                arr[cur] = arr[left];
                arr[left] = temp;
                left++;
                cur++;

            }
        }
        return new int[]{left, right};
    }
    public void quickSort(int[] arr, int left, int right) {
        /*
        * 非递归依赖 栈这种结构 ,递归是系统压栈 , 非递归是手动压栈
        * 模拟系统压栈,将必要条件封装入栈,然后判断栈是否为空
        * */
        Stack<Condition> stack = new Stack<Condition>();
        if (left >= right)
            return;
        stack.add(new Condition(left, right));
        while (stack.isEmpty() == false) {
            Condition condition = stack.pop();
            left = condition.getLeft();
            right = condition.getRight();
            if (left >= right)
                continue;
            int indexs[] = partition(arr, left, right);
            stack.add(new Condition(left, indexs[0] - 1));
            stack.add(new Condition(indexs[1] + 1, right));
        }
    }

}
/*
* 封装了递归的条件
*
* */
class Condition{
    private  int left;
    private  int right;
    public Condition(int left, int right) {
        this.left = left;
        this.right = right;
    }
    public int getLeft() {
        return left;
    }
    public int getRight() {
        return right;
    }

}
