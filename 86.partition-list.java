/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        //使用两个链表，一个链表存储小于x的节点，另一个链表存储大于等于x的节点
        //方法1 ： 在原来的链表上进行操作， 要注意的是，最后一个节点的next要置为null
        //方法2 ： 创建一个新的链表， 但是这样会消耗额外的空间

        //方法1
        ListNode dummy_1 = new ListNode(-1), p1 = dummy_1;
        ListNode dummy_2 = new ListNode(-1), p2 = dummy_2;
        ListNode p = head;

        //进行基本的判断
        while (p != null){ //在这进行p的循环
            if (p.val < x){
                p1.next = p;
                p1 = p1.next;
            }else{
                p2.next = p;
                p2 = p2.next;
            }

            //处理原链表上的最后一个节点
            //断开原链表中的每个节点的 next 指针，同时将这些节点串联成一个新的链表。
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        //将两个链表进行合并
        p1.next = dummy_2.next;

        return dummy_1.next;
    }
}
// @lc code=end

