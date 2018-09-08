package algorithms.easy._235_lca_of_bst;

import datastructures.tree.TreeNode;

/**
 * 235 - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
class Solution {
    /**
     * Assumes p, q != null
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (p.getVal() > q.getVal()) {
            return lowestCommonAncestor(root, q, p);
        }

        if (p.getVal() < root.getVal() && q.getVal() < root.getVal()) {
            return lowestCommonAncestor(root.getLeft(), p, q);
        } else if (p.getVal() > root.getVal() && q.getVal() > root.getVal()) {
            return lowestCommonAncestor(root.getRight(), p, q);
        }

        return root;
    }
}