/*
 * @lc app=leetcode id=876 lang=java
 *
 * [876] Middle of the Linked List
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
    public ListNode middleNode(ListNode head) {
         //判断特殊情况
         if (head == null || head.next == null){
            return head;
        }
        //创建两个指针
        ListNode slow = head, fast = head;
        //遍历链表
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //返回结果
        return slow;
    }
}
// @lc code=end

