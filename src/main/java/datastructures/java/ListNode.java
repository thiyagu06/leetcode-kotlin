package datastructures.java;

/**
 * Definition for singly-linked list.
 */
@SuppressWarnings({ "WeakerAccess", "CanBeFinal" })
public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
