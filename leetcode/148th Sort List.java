// 148. Sort List

// Given the head of a linked list, return the list after sorting it in ascending order.

 

// Example 1:


// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
// Example 2:


// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]
// Example 3:

// Input: head = []
// Output: []
 

// Constraints:

// The number of nodes in the list is in the range [0, 5 * 104].
// -105 <= Node.val <= 105
 

// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

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

//Using Merge Sort

class Solution{
    public ListNode sortList(ListNode head){
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode head1 = mergeSort(head);
        ListNode head2=mergeSort(slow);
        ListNode ans = merge(head1,head2);
        return ans;
    }
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode ansHead = new ListNode(-1);
        ListNode ansTail=ansHead;
        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                ansTail.next=new ListNode(head1.val);
                head1=head1.next;
            }else{
                ansTail.next=new ListNode(head2.val);
                head2=head2.next;
            }
            ansTail=ansTail.next;
        }
        while(head1!=null){
            ansTail.next=new ListNode(head1.val);
            head1=head1.next;
            ansTail=ansTail.next;
        }
        while(head2!=null){
            ansTail.next=new ListNode(head2.val);
            head2=head2.next;
            ansTail=ansTail.next;
        }
        ListNode t1=ansHead;
        ansHead=ansHead.next;
        t1.next=null;
        return ansHead;
    }
}

// Conveting LL to Array and than again in LL

// class Solution {
//     public ListNode sortList(ListNode head) {
//         if(head==null || head.next==null){
//             return head;
//         }
//         ListNode temp=head;
//         ArrayList<Integer> list=new ArrayList<>();
//         while(temp!=null){
//             list.add(temp.val);
//             temp=temp.next;
//         }
//         Collections.sort(list);
//         ListNode resNode = new ListNode(list.get(0));
//         ListNode nextNode=resNode;
//         for(int i=1;i<list.size();i++){
//             nextNode.next=new ListNode(list.get(i));
//             nextNode=nextNode.next;
//         }
//         return resNode;
//     }
// }
