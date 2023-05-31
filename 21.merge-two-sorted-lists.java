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
        ListNode dummy = new ListNode(-1);
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode p = dummy;

        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                p.next = p2;
                p2 = p2.next;
        }else{
            p.next = p1;
            p1 = p1.next;
        }
        //p指针不断前进
         p = p.next;
        }

        ///////////////////////////////
        //当有一个链接已经走完了之后， 另外一个链表还有剩下的，直接把第二个链表的东西， 接到第一个链表上面
        //p1指针前进
        if (p1 != null){
            p.next = p1;
        }
        //p2指针前进
        if (p2 != null){
            p.next = p2;
        }
        return dummy.next;
    }
}
// @lc code=end

