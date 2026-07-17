// 61. Rotate List

// Given the head of a linked list, rotate the list to the right by k places.
// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
// Example 2:
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]
// Constraints:
// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        for (int i = 0; i < k; i++) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            curr.next = head;
            head = curr;
        }
        return head;
    }
}
