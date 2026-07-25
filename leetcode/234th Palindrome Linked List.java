// 234. Palindrome Linked List

// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

// Example 1:


// Input: head = [1,2,2,1]
// Output: true
// Example 2:


// Input: head = [1,2]
// Output: false
 

// Constraints:

// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9
 

// Follow up: Could you do it in O(n) time and O(1) space?

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

 //1st approach 

// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         ListNode prev = null;
//         ListNode slow = head;
//         ListNode fast = head;
//         ListNode newListHead = null;   // FIX: variable name

//         // creating while finding middle node
//         while (fast != null && fast.next != null) {
//             prev = slow;
//             slow = slow.next;
//             fast = fast.next.next;
//             if(newListHead == null) {
//                 newListHead = new ListNode(prev.val);
//             }else{
//                 ListNode node = new ListNode(prev.val);
//                 node.next = newListHead;
//                 newListHead = node;
//             }
//         }
//         // if list is odd length (skip middle)
//         if (fast != null) {
//             slow = slow.next;
//         }
//         while (slow != null && newListHead != null) {
//             if (slow.val != newListHead.val) {
//                 return false;
//             }
//             slow = slow.next;
//             newListHead = newListHead.next;
//         }
//         return true;
//     }
// }

//2nd approach 

class Solution {
    public ListNode findMiddle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head){
        if(head==null || head.next==null){
            return true;
        }
        ListNode temp=head;
        ListNode middle=findMiddle(head);
        ListNode tail=reverseList(middle);
        while(tail!=null){
            if(tail.val!=temp.val){
                return false;
            }
            tail=tail.next;
            temp=temp.next;
        }
        return true;
    }
}