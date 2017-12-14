package algorithms.easy._237_delete_node_in_linked_list;

import datastructures.java.ListNode;

/**
 * 237 - https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }

        while (node.next != null) {
            node.val = node.next.val;

            if (node.next.next == null) {
                node.next = null;
                return;
            }

            node = node.next;
        }
    }
}