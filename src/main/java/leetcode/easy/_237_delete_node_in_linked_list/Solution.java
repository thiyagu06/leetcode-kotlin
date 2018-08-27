package algorithms.easy._237_delete_node_in_linked_list;

/**
 * 237 - https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 */
class Solution {
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
