package leetcode.easy._141_linked_list_cycle;

import datastructures.list.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 141 - https://leetcode.com/problems/linked-list-cycle/description/
 */
class Solution {

    /**
     * Time: O(n) - see https://leetcode.com/problems/linked-list-cycle/solution/
     * Space: O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.getNext() != null) {
            tortoise = tortoise.getNext();
            hare = hare.getNext().getNext();

            if (tortoise == hare) {
                return true;
            }
        }

        return false;
    }

    /**
     * Simpler but uses O(n) space for HashSet.
     * Time: O(n) - where m is the length of first linked list and n is the length of second linked list
     * Space: O(n)
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        final Map<ListNode, Boolean> nodes = new HashMap<>();
        while (head != null) {
            if (nodes.containsKey(head)) {
                return true;
            }
            nodes.put(head, true);
            head = head.getNext();
        }
        return false;
    }
}