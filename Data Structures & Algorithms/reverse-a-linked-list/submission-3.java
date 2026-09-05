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
    // null <- 0 <- 1 <- 2 <- 3
    // null <- 0
    //     cur = 0
    // newHead = 3
    public ListNode reverseHead(ListNode cur) {
        if (cur == null) {
            return cur;
        }
        ListNode newHead = cur;
        if (cur.next != null) {
            newHead = reverseHead(cur.next);
            cur.next.next = cur;
        }
        cur.next = null;

        return newHead;
    }
    public ListNode reverseList(ListNode head) {
        // ListNode prev = null;
        // ListNode cur = head;
        // while (cur != null) {
        //     ListNode temp = cur.next;
        //     cur.next = prev;
        //     prev = cur;
        //     cur = temp;
        // }
        // return prev;
        return reverseHead(head);
    }
}
