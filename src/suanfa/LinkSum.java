package suanfa;

import java.util.List;

public class LinkSum {
    public static void main(String[] args) {
//        ListNode nodeSta = new ListNode(0);
//        ListNode nextNode;
//        nextNode = nodeSta;
//        for (int i = 1; i < 10; i++){
//            ListNode node = new ListNode(i);
//            nextNode.next = node;
//            nextNode = nextNode.next;
//        }
//        nextNode = nodeSta;
//        print(nextNode);
        ListNode l1 = new ListNode(1);
        ListNode nextNode;
        nextNode = l1;
        ListNode node = new ListNode(2);
        nextNode.next = node;
        nextNode = nextNode.next;
        ListNode node1 = new ListNode(3);
        nextNode.next = node1;
        nextNode = nextNode.next;
        nextNode = l1;

        ListNode l2 = new ListNode(3);
        ListNode nextNode2;
        nextNode2 = l2;
        ListNode node3 = new ListNode(4);
        nextNode2.next = node3;
        nextNode2 = nextNode2.next;
        ListNode node4 = new ListNode(5);
        nextNode2.next = node4;
        nextNode2 = nextNode2.next;
        nextNode2 = l2;
       // print(l2);
        print(addTwoNumbers(l1,l2));


    }
    //打印输出方法
    static void print(ListNode listNoed){
        //创建链表节点
        while(listNoed!=null){
            System.out.println("节点:"+listNoed.val);
            listNoed=listNoed.next;
        }
        System.out.println();
    }
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。
     * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     */
    /**
     * 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
     *
     * 我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。
     * 具体而言，如果当前两个链表处相应位置的数字为 n1,n2n1,n2，进位值为 \textit{carry}carry，
     * 则它们的和为 n1+n2+\textit{carry}n1+n2+carry；
     * 其中，答案链表处相应位置的数字为 (n1+n2+\textit{carry}) \bmod 10(n1+n2+carry)mod10，
     * 而新的进位值为 \lfloor\frac{n1+n2+\textit{carry}}{10}\rfloor⌊
     * 10
     * n1+n2+carry
     * ​
     *  ⌋。
     *
     * 如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个 00 。
     *
     * 此外，如果链表遍历结束后，有 \textit{carry} > 0carry>0，还需要在答案链表的后面附加一个节点，
     * 节点的值为 \textit{carry}carry。

     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = null,tail = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null){
                head = tail = new ListNode(sum % 10);
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }
}

class ListNode {        //类名 ：Java类就是一种自定义的数据结构
    int val;            //数据 ：节点数据
    ListNode next;      //对象 ：引用下一个节点对象。在Java中没有指针的概念，Java中的引用和C语言的指针类似

    ListNode(int val){  //构造方法 ：构造方法和类名相同
        this.val=val;     //把接收的参数赋值给当前类的val变量
    }
}

