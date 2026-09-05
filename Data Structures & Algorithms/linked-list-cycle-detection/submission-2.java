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
    public boolean hasCycle(ListNode head) {
        // // Approach 1
        // HashSet<ListNode> set = new HashSet<>();
        // ListNode cur = head;
        // while (cur != null) {
        //     if (set.contains(cur)) {
        //         return true;
        //     }
        //     set.add(cur);
        //     cur = cur.next;
        // }
        // return false;

        // Approach 2
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

/*

Approach 1: O(n) time, O(n) space
Keep a set of visited nodes
If we stumble upon a visited node, return true
If we iterate through all the nodes, return false

Approach 2: O(n) time, O(1) space
Keep two pointers: one that moves with speed 1 and another one that moves with speed 2
If they ever overlap, there is a cycle
If the faster node reaches the end, there is no cycle

*/

