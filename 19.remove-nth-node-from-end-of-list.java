/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
         * 定义两个指针， 一个走n步，然后两个指针一起走，
         * 当快指针走到尾部时，慢指针的下一个节点就是要删除的节点
         */
        //判断特殊情况
        if (head == null || head.next == null){
            return null;
        }

        //定义一个虚拟头节点
        ListNode dummy = new ListNode(1);
        dummy.next = head;

        //创建两个指针
        ListNode slow = dummy, fast = dummy;

        //快指针先走n步
        while (n-- > 0){
            fast = fast.next;
        }

        //两个指针一起走
        while (fast.next != null){ //这里是fast.next != null
            slow = slow.next;
            fast = fast.next;
        }

        //删除节点， 
        //不用判断是否是头节点，因为有虚拟头节点
        slow.next = slow.next.next;

        return dummy.next;
    }
}
// @lc code=end

