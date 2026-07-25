// Linked List Group Reverse

// Given the head of a Singly linked list. Reverse every k node in the linked list and return the head of the modified list.
// Note: If the number of nodes is not a multiple of k then the left-out nodes at the end, should be considered as a group and must be reversed.
// Examples:
// Input: head: 1 -> 2 -> 3 -> 4 -> 5 -> 6, k = 2
// Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
// Explanation: Linked List is reversed in a group of size k = 2.
// Input: head: 1 -> 2 -> 3 -> 4 -> 5 -> 6, k = 4,
// Output: 4 -> 3 -> 2 -> 1 -> 6 -> 5
// Explanation: Linked List is reversed in a group of size k = 4.
// Constraints:
// 1 ≤ size of linked list ≤ 105
// 0 ≤ node->data ≤ 106
// 1 ≤ k ≤ size of linked list 

/* Structure of linked list Node
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
 */
class Solution {

    public Node reverseKGroup(Node head, int k) {
        Node prevHead = null;
        Node currHead = head;
        Node ansNode = null;
        while (currHead != null) {
            Node prev = null;
            Node curr = currHead;
            Node nextNode = null;
            //Reverse K-Groups
            int j = 0;
            while (j < k && curr != null) {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                j++;
            }
            if (prevHead == null) {
                ansNode = prev;
            } else {
                prevHead.next = prev;
            }
            prevHead = currHead;
            currHead = curr;
        }
        return ansNode;
    }
}
