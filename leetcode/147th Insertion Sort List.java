// 147. Insertion Sort List

// Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

// The steps of the insertion sort algorithm:

// Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
// At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
// It repeats until no input elements remain.
// The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.


 

// Example 1:


// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
// Example 2:


// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]
 

// Constraints:

// The number of nodes in the list is in the range [1, 5000].
// -5000 <= Node.val <= 5000

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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp=head.next;
        ListNode sortedTail=head;
        while(temp!=null){
            if(temp.val>=sortedTail.val){
                sortedTail=temp;
                temp=temp.next;
                continue;
            }
            sortedTail.next=temp.next;
            //temp.next=null;
            ListNode prev=null;
            ListNode t1=head;
            while(t1!=sortedTail.next){
                if(t1.val>=temp.val){
                    break;
                }
                prev=t1;
                t1=t1.next;
            }
            //insert at head
            if(prev==null){
                temp.next=head;
                head=temp;
            }else{
                //insert at specific position
                temp.next=prev.next;
                prev.next=temp;
            }
            temp=sortedTail.next;
        }
        return head;
    }
}