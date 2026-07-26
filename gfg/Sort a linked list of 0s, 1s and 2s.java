// Sort a linked list of 0s, 1s and 2s

// Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.
// Examples:
// Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
// Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
// Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:
// Input: head = 2 → 2 → 0 → 1
// Output: 0 → 1 → 2 → 2
// Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be:
// Constraints:
// 1 ≤ no. of nodes ≤ 106
// 0 ≤ node->data ≤ 2

/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/
class Solution {

    public Node segregate(Node head) {
        // code here
        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(-1);
        Node oneTail = oneHead;
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;
        Node temp = head;
        while (temp != null) {
            Node nextNode = temp.next;
            if (temp.data == 0) {
                temp.next = null;
                zeroTail.next = temp;
                zeroTail = zeroTail.next;
            } else if (temp.data == 1) {
                temp.next = null;
                oneTail.next = temp;
                oneTail = oneTail.next;
            } else {
                temp.next = null;
                twoTail.next = temp;
                twoTail = twoTail.next;
            }
            temp = nextNode;
        }
        if (oneHead.next == null) {
            zeroTail.next = twoHead.next;
        } else {
            zeroTail.next = oneHead.next;
            oneTail.next = twoHead.next;
        }
        //deleting dummy nodes
        oneHead.next = null;
        twoHead.next = null;
        Node t1 = zeroHead;
        zeroHead = zeroHead.next;
        t1.next = null;
        return zeroHead;
    }
}
