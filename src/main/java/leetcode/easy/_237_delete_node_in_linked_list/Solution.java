package leetcode.easy._237_delete_node_in_linked_list;

import datastructures.list.ListNode;

/**
 * 237 - https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }

        while (node.getNext() != null) {
            node.setVal(node.getNext().getVal());

            if (node.getNext().getNext() == null) {
                node.setNext(null);
                return;
            }

            node = node.getNext();
        }
    }
}
