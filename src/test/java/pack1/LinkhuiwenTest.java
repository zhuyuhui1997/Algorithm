package pack1;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class LinkhuiwenTest {
    Linkhuiwen linkhuiwen;
    LinkList linkList;
    public void init() {
        linkList = new LinkList();
        Random random = new Random();
        int length = random.nextInt(10) + 1;
        for (int i = 0; i < length; i++) {
            Node<Integer> node = new Node<Integer>();
            node.value = random.nextInt(11);
            linkList.add(node);
        }
    }
    @Test
    public void test() {
        linkhuiwen = new Linkhuiwen();
        for (int i = 0; i < 10000; i++) {
            init();
            String s = linkList.toString();
            boolean flag = linkhuiwen.JudegHuiwen(linkList.head);
            if (flag)
            {
                System.out.println("判断回文之前的状态: " + s);
                System.out.println("判断回文之后的状态: " + linkList.toString());
            }

        }
    }

}