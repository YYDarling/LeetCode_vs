/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {
        /*
         * 1. 先通过双指zhizhen找到链表的中间节点
         * 2. 把链表的后半部分反转
         * 3. 通过双指针判断是否回文
         * 4. 恢复链表
         */
        if (head == null || head.next == null){
            return true;
        }

        //1.通过双指针找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //要判断链表的长度是奇数还是偶数
        //如果fast指针没有指向null，说明链表长度为奇数，slow还要再前进一步
        if (fast != null){
            slow = slow.next;
        }

        //2.把链表的后半部分反转
        ListNode left = head;
        ListNode right = reverse(slow);

        //3.通过双指针判断是否回文
        while (right != null){
            if (left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// @lc code=end

