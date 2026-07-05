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
    public int goodNodes(TreeNode root) {
        int res = 0;
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, Integer.MIN_VALUE));

        while(!q.isEmpty()){
          Pair<TreeNode, Integer> curr = q.remove();
          TreeNode node = curr.getKey(); 
          int maxval = curr.getValue();

          if( node.val >= maxval ) res++;

          if( node.left != null) q.add( new Pair<>(node.left, Math.max(node.val,maxval))) ;
          if( node.right != null) q.add(new Pair<>(node.right, Math.max(node.val, maxval)));
        }
        return res;
    }
}
