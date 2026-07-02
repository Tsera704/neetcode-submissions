/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if( root == null) return 0;

        dfs(root);
        return maxD;
    }
    public int dfs( TreeNode node){
        if( node == null) return 0;
        int l = dfs( node.left);
        int r = dfs(node.right);
        maxD = Math.max( maxD, l+r);
        return 1 + Math.max(l , r);
    }
}
