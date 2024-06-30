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
    int max;
    public int maxPathSum(TreeNode root) {
        if(root == null)
        return 0;
        max=Integer. MIN_VALUE;
        helper(root);
        return max;
    }
    public int helper(TreeNode node){
        if(node == null)
         return 0;
        int lh = Math.max(0,helper(node.left));
        int rh = Math.max(0,helper(node.right));
        max = Math.max(max,lh+rh+node.val);
        return Math.max(lh,rh)+node.val;
    }
}