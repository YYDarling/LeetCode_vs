/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //     /*
    //      * 方法一：迭代
    //      * 思路：先把反转的函数写出来， 
    //      * 1.找到left节点的前一个节点，记为pre
    //      * 2.找到right节点，记为rightNode
    //      * 3.把left节点到right节点的链表截取下来，记为subHead
    //      * 4.把subHead反转
    //      * 5.把pre.next指向反转后的subHead
    //      * 6.把subHead.next指向rightNode
    //      * 7.返回head
    //      */
    //     //因为头节点可能发生变化，使用dummy节点进行辅助
    //     ListNode dummy = new ListNode(-1);
    //     dummy.next = head;

    //     //1.找到left节点的前一个节点，记为pre, 也就是left的前一个节点
    //     ListNode pre = dummy;
    //     for (int i = 0; i < left - 1; i++){
    //         pre = pre.next;
    //     }

    //     //2.找到right节点，记为rightNode
    //     ListNode rightNode = dummy;
    //     for (int j = 0; j < right; j++){
    //         rightNode = rightNode.next;
    //     }

    //     //3.切断出一个子链表，leftNode and cur, 保存住当前的pre.next, 也就是left的前一个节点
    //     //保存住当前的rightNode.next, 也就是right的后一个节点
    //     ListNode leftNode = pre.next;
    //     ListNode cur = rightNode.next;

    //     //4.切断链表
    //     pre.next = null;
    //     rightNode.next = null;

    //     //5.反转子链表
    //     reverseLinkedlist(leftNode);

    //     //6.把反转后的子链表重新接回原来的链表中
    //     pre.next = rightNode;
    //     leftNode.next = cur;

    //     return dummy.next;
    // }

    // //反转链表
    // private void reverseLinkedlist(ListNode head){
    //     ListNode pre = null, cur = head;
    //     while (cur != null){
    //         ListNode temp = cur.next;
    //         //反转
    //         cur.next = pre;
    //         //更新
    //         pre = cur;
    //         cur = temp;
        // }
        
        
        /*
         * 方法二：递归
         */

        //递归的终止条件
        

    }
    //反转整个链表
    private ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode last = reverse(head.next);
        //连接
        head.next.next = head;
        head.next = null;
        return last;
    }

    //反转链表前N个节点
    //后驱节点
    ListNode successor = null;
    private ListNode reverseN(ListNode head, int n){
        if (n == 1){
            //记录第n+1个节点
            successor = head.next;
            return head;
        }

        //以head.next为起点，需要反转前n-1个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        //让反转之后的head节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    //反转链表的一部分
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            // base case
            if (m == 1) {
                return reverseN(head, n);
            }
            // 前进到反转的起点触发 base case
            head.next = reverseBetween(head.next, m - 1, n - 1);
            return head;
        }
    
        ListNode successor = null; // 后驱节点
        // 反转以 head 为起点的 n 个节点，返回新的头结点
        ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                // 记录第 n + 1 个节点
                successor = head.next;
                return head;
            }
            // 以 head.next 为起点，需要反转前 n - 1 个节点
            ListNode last = reverseN(head.next, n - 1);
    
            head.next.next = head;
            // 让反转之后的 head 节点和后面的节点连起来
            head.next = successor;
            return last;
        }
    }
}
// @lc code=end

