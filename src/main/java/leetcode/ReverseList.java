package leetcode;

import java.util.List;

/**
 * @Description: TODO
 * @Author: UncleBryan
 * @Date: 2021/8/26 21:45
 */
public class ReverseList {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 迭代
     * @param curr
     * @return
     */
    public static ListNode iterator(ListNode curr){
        //保存当前节点
        ListNode prev=null;
        //保存当前节点的下一个元素
        ListNode next;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 递归的本质是栈
     * @param head
     * @return
     */
    public static ListNode recursion(ListNode head){
        //边界
        if(head==null || head.next==null){
            return head;
        }
        //递归入栈
        ListNode new_head = recursion(head.next);
        //递归内部执行逻辑
        head.next.next = head;
        head.next = null;
        //递归的出口
        return new_head;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode result = ReverseList.iterator(node1);
//        ListNode recursion = ReverseList.recursion(node1);
        System.out.println(result);
    }
}