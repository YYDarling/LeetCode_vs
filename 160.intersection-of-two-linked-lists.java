/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
         * 如果相交， 返回相交的节点， 否则返回null
         * 方法： 两个指针， 一个指向A， 一个指向B， 同时向前走， 
         * 当一个走到头， 就指向另一个的头， 继续走， 
         * 相遇的节点就是相交的节点
         */
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2){
            // 如果p1走到头， 就指向headB
            p1 = (p1 == null) ? headB : p1.next;
            // 如果p2走到头， 就指向headA
            p2 = (p2 == null) ? headA : p2.next;
        }
        return p1;
    }
}
// @lc code=end

