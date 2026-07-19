// Pairwise swap elements of a linked list

// Given the head of a singly linked list, swap every two adjacent nodes and return the new head.
// Note: Try to swap the nodes, not only the data.
// Examples:
// Input: head = 1 -> 2 -> 3 -> 4 -> 5
// Output: 2 -> 1 -> 4 -> 3 -> 5
// Explanation: The list has 5 nodes, so we form pairs from the front: [1, 2], [3, 4], and 5 remains unpaired (odd node count).
// Swapping each pair gives: [2, 1], [4, 3], and 5 stays as is.
// Final list: 2 -> 1 -> 4 -> 3 -> 5.
// Input: head = 8 -> 7 -> 5 -> 2 -> 1
// Output: 7 -> 8 -> 2 -> 5 -> 1
// Explanation: The list has 5 nodes, so we form pairs from the front: [8, 7], [5, 2], and 1 remains unpaired (odd node count).
// Swapping each pair gives: [7, 8], [2, 5], and 1 stays as is.
// Final list: 7 -> 8 -> 2 -> 5 -> 1.
// Constraints:
// 1 ≤ size of linked list ≤ 106
// 1 ≤ elements of linked list ≤ 106

/* Structure of linked list Node
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
};*/
class Solution {

    public Node pairwiseSwap(Node head) {
        // code here
        Node first = head;
        Node prev = null;
        while (first != null && first.next != null) {
            Node second = first.next;
            first.next = second.next;
            second.next = first;
            if (prev == null) {
                head = second;
            } else {
                prev.next = second;
            }
            prev = first;
            first = first.next;

        }
        return head;
    }
}
