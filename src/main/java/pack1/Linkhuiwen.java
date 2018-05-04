package pack1;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/*
* author kl
* 处理链表是否回文的判断
* */
public class Linkhuiwen {
    public boolean JudegHuiwen(Node head) {
        //如果是空,或者只有一个节点 ,返回true
        if (head == null || head.next ==null)
            return true;
        Node slow = head;
        Node fast = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null)
                fast = fast.next;
            slow = slow.next;
        }
        /*
        * slow  指向后半部第一个节点
        * fast 指向最后一个节点
        * */
        Node pre = slow;
        Node cur = slow.next;
        slow.next = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        Node p = head;
        //此时slow 处于后半部第一个节点,且没有next
        //fast指向最后一个节点
        //比如 8->1->0->1->8
        //8->1->0   0<-1<-8
        //然后判断
        boolean flag = true;
        while (p != slow) {
            if (p.value != fast.value) {
                flag = false;
                break;
            }
            p = p.next;
            fast = fast.next;
        }
        /*
        * 修复链表
        * 此时pre 指向最后一个节点
        * */
        cur = pre.next;
        pre.next = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return flag;

    }
}
class Node<T> {
    T value;
    Node next;
    public String toString() {
        return value + "";
    }

}
class LinkList{
    Node head;
    Node tail;
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(head.toString());
        Node cur = head.next;
        while (cur != null) {
            stringBuilder.append("->" + cur.toString());
            cur = cur.next;
        }
        return stringBuilder.toString();
    }

    public void add(Node node) {
        if (node == null)
            return;
        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }

    }
}