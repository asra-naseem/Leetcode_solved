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
    int Sum =0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)
        return Sum;
        if(root.val >=low && root.val<=high)
        Sum = Sum+root.val;
       int left = rangeSumBST(root.left,low,high);
       int right = rangeSumBST(root.right,low,high);
        return Sum;
        

        
    }
}