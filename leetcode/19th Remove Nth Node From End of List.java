// 19. Remove Nth Node From End of List

// Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

// Example 1:


// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]
// Example 2:

// Input: head = [1], n = 1
// Output: []
// Example 3:

// Input: head = [1,2], n = 1
// Output: [1]
 

// Constraints:

// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
 

// Follow up: Could you do this in one pass?

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
        if(head==null || head.next==null){
            return null; 
            // as in constraint we have that n at least 1 and sz at least 1 - so if size is 1 than returns null
        }
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        int size=count-n;
        if(size==0){
            return head.next;
            // if on the first index than just giving head.next
        }
        ListNode prev=null;
        ListNode curr=head;
        for(int i=0;i<size;i++){
            prev=curr;
            curr=curr.next;
        }
        prev.next=curr.next;
        curr.next=null;
        return head;
    }
}