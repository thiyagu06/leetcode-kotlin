package algorithms.easy._160_intersection_linked_list;

import java.util.HashSet;
import java.util.Set;
import java.util.function.UnaryOperator;

/**
 * 160 - https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */
public class Solution {

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
    public ListNode getIntersectionNodeAlt(ListNode headA, ListNode headB) {
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
