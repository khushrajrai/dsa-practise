// Split a Linked List into two halves

// Given a Circular linked list. The task is split into two Circular Linked lists. If there are an odd number of nodes in the given circular linked list then out of the resulting two halved lists, the first list should have one node more than the second list.
// Examples :
// Input: LinkedList : 10->4->9
// Output: 10->4 , 9
// Explanation: After dividing linked list into 2 parts , the first part contains 10, 4 and second part contain only 9.
// Input: LinkedList : 10->4->9->10
// Output: 10->4 , 9->10
// Explanation: After dividing linked list into 2 parts , the first part contains 10, 4 and second part contain 9, 10.
// Constraints:
// 2 <= number of nodes <= 105
// 1 <= node->data <= 103

/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 */
class Solution {

    public Pair<Node, Node> splitList(Node head) {
        // Code here
        Node slow = head;
        Node fast = head;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //move fast to last node for even numbers of nodes
        if (fast.next.next == head) {
            fast = fast.next;
        }
        Node head1 = head;
        Node head2 = slow.next;
        slow.next = head1;
        fast.next = head2;
        return new Pair<>(head1, head2);
    }
}
