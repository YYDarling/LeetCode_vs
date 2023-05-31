/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        /*
         * 方法一：迭代
         * 方法二：递归
         */
         
        /*
         * 方法一：迭代
         * 定义两个指针， 一个指向pre， 一个指向cur
         * 每次迭代，将cur的下一个节点指向pre， 然后更新pre和cur
         * 最后返回pre
         * //判断特殊情况
        if (head == null || head.next == null){
            return head;
        }

        //定义两个指针
        ListNode pre = null, cur = head;

        //开始迭代
        while (cur != null){
            //使用一个temp 来保存当前cur的下一个节点
            ListNode temp = cur.next;

            //将cur的下一个节点指向pre
            cur.next = pre;

            //更新pre和cur， 同时往前移动
            pre = cur;
            cur = temp;
        }
        return pre;
         */

        /*
        * 方法二：递归 
        */
        //判断特殊情况
        if (head == null || head.next == null){
            return head;
        }

        //递归
        ListNode last = reverseList(head.next);
        //反转, 此时head.next.next是指向null的， 需要让他重新指向head才行
        head.next.next = head;
        //断开head和head.next的连接
        head.next = null;

        return last;

        
    }
}
// @lc code=end

