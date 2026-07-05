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
    public boolean isValidBST(TreeNode root) {
        if ( root == null) return true;
        Queue<Object[]> q= new LinkedList<>();
        q.add(new Object[]{root, Long.MIN_VALUE, Long.MAX_VALUE});
        while(!q.isEmpty()){
            Object[] curr = q.remove();
            TreeNode node = (TreeNode) curr[0];
            long leftval = (long) curr[1];
            long rightval = (long) curr[2];

            if( leftval >= node.val || rightval <= node.val) return false;

            if( node.left != null){
                q.add(new Object[]{node.left, leftval, (long)node.val});
            }
            if( node.right != null){
                q.add(new Object[]{node.right, (long)node.val, rightval});
            }
        }
        return true;
    }
}
