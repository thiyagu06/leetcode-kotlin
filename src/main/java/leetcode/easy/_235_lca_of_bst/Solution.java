package leetcode.easy._235_lca_of_bst;

/**
 * 235 - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
class Solution {
    /**
     * Assumes p,q != null
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}