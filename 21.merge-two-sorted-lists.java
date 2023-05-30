/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头结点, 新的一个链表
        ListNode dummy = new ListNode(-1), p = dummy; 
        ListNode p1 = list1, p2 = list2;
        
        while(p1 != null && p2 != null){
            if (p1.val <= p2.val){
                p.val = p1.val;
                p1 = p1.next;
            }else{
                p.val = p2.val;
                p2 = p2.next;
            }
            // p 指针不断前进
            p = p.next; 
        }
        // 退出循环后，p1 或者 p2 有一个不为空
        if (p1 != null){
            p.next = p1;  //p2 为空, 提前结束
        }
        if (p2 != null){
            p.next= p2;  //p1 为空, 提前结束
        }
        return dummy.next;
    }
}
// @lc code=end

