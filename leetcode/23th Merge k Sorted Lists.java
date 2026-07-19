// 23. Merge k Sorted Lists

// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

 

// Example 1:

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted linked list:
// 1->1->2->3->4->4->5->6
// Example 2:

// Input: lists = []
// Output: []
// Example 3:

// Input: lists = [[]]
// Output: []
 

// Constraints:

// k == lists.length
// 0 <= k <= 104
// 0 <= lists[i].length <= 500
// -104 <= lists[i][j] <= 104
// lists[i] is sorted in ascending order.
// The sum of lists[i].length will not exceed 104.

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
    public ListNode mergeKLists(ListNode[] lists) {
        //creating a newArr containing all values from arrays of linkedlists
        List<Integer> newArr = new ArrayList<>();
        for(ListNode k:lists){
            while(k!=null){
               newArr.add(k.val);
               k=k.next;
            }
        }
        if(newArr.size()==0){
            return null; //empty newArr returns null
        }
        Collections.sort(newArr);
        //now making the ArrayList to linkedlist
        ListNode head=new ListNode(newArr.get(0));
        ListNode curr=head;
        for(int i=1;i<newArr.size();i++){
         curr.next=new ListNode(newArr.get(i));
         curr=curr.next;
        }
        return head;
    }
}