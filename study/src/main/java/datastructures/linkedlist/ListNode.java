package datastructures.linkedlist;

// Related to Leetcode #21
public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this(val);
        this.next = next;
    }
}
