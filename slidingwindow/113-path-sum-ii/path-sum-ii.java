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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<Integer>();
        helperPathSum(root,targetSum,list);
        return ans;
        
    }
    public void helperPathSum(TreeNode root , int target,List<Integer> list){
        if(root==null)
        return;
        list.add(root.val);
        if(root.left==null && root.right==null && target == root.val)
        {
            ans.add(new ArrayList<>(list));
           
        }
        helperPathSum(root.left,target-root.val,list);
        helperPathSum(root.right,target-root.val,list);
        list.remove(list.size()-1);
    }
}