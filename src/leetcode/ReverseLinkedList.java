package leetcode;

import leetcode.LinkedListHelper.ListNode;

import static leetcode.LinkedListHelper.printList;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:

Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        printList(head);
        ListNode reversedHead = reverseLinkedList.reverseListIterative(head);
        printList(reversedHead);

        head = new ListNode(1, new ListNode(2));
        printList(head);
        reversedHead = reverseLinkedList.reverseListRecursive(head);
        printList(reversedHead);
    }

    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            // Store next node
            next = curr.next;
            // Reverse current node's pointer
            curr.next = prev;
            // Move pointers one position ahead
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Reverse the rest list and put the first element at the end
        ListNode rest = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        // Fix the head pointer
        return rest;
    }
}
