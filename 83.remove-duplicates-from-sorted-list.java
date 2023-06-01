/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
    public ListNode deleteDuplicates(ListNode head) {
        /*
         * 方法：双指针法
         */
         //特殊情况
         if (head == null || head.next == null) return head;

         //定义两个指针
         ListNode slow = head, fast = head.next;
         while (fast != null){
            if (slow.val != fast.val){
                //先运行slow++，再赋值, 因为要先把位置空出来
                slow.next = fast; //这里是把slow.next指向fast, 直接进行连接
                slow = slow.next;
            }
            fast = fast.next;
         }
         //这里是把slow.next指向null, 断开连接
         slow.next = null;
         return head; //返回头结点, 新的链表
    }
}
// @lc code=end

