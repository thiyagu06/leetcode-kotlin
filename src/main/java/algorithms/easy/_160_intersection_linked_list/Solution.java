package algorithms.easy._160_intersection_linked_list;

import java.util.HashSet;
import java.util.Set;
import java.util.function.UnaryOperator;

/**
 * 160 - https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */
public class Solution {

    /**
     * Time: O(m + n)
     * Space: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final int list1Size = sizeOfList(headA);
        final int list2Size = sizeOfList(headB);
        final int sizeDiff = Math.abs(list1Size - list2Size);

        ListNode longerListNode = (list1Size >= list2Size) ? headA : headB;
        ListNode shorterListNode = (list1Size >= list2Size) ? headB : headA;

        for (int i = 0; i < sizeDiff; i++) {
            longerListNode = longerListNode.next;
        }

        while (shorterListNode != null && longerListNode != null) {
            if (shorterListNode.equals(longerListNode)) {
                return shorterListNode;
            }

            shorterListNode = shorterListNode.next;
            longerListNode = longerListNode.next;
        }

        return null;
    }

    private int sizeOfList(ListNode head) {
        if (head == null) {
            return 0;
        }

        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }

        return size;
    }


    /**
     * Time: O(m + n)
     * Space: O(1)
     */
    public ListNode getIntersectionNodeAlt(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;
        ListNode p1NextList = headB;
        ListNode p2NextList = headA;
        ListNode lastA = null;
        ListNode lastB = null;

        // Alternate which list to iterate next.
        final UnaryOperator<ListNode> nextList = (currentNextList) ->
                (currentNextList == headA) ? headB : headA;

        while (p1 != p2) {
            // compare lasts
            if (lastA != null && lastB != null && lastA != lastB) {
                return null;
            }

            // set next A
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                if (lastA == null) lastA = p1;

                p1 = p1NextList;
                p1NextList = nextList.apply(p1NextList);
            }

            // set next B
            if (p2.next != null) {
                p2 = p2.next;
            } else {
                if (lastB == null) lastB = p2;

                p2 = p2NextList;
                p2NextList = nextList.apply(p2NextList);
            }
        }

        return p1;
    }

    /**
     * Suboptimal space
     * Time: O(m + n)
     * Space: O(m) or O(n)
     */
    public ListNode getIntersectionNodeSuboptimal(ListNode headA, ListNode headB) {
        final Set<ListNode> visited = new HashSet<>();
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null) {
            // no cycles, don't need to check
            visited.add(nodeA);
            nodeA = nodeA.next;
        }

        while (nodeB != null) {
            if (visited.contains(nodeB)) {
                return nodeB;
            }

            visited.add(nodeB);
            nodeB = nodeB.next;
        }

        return null;
    }

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
