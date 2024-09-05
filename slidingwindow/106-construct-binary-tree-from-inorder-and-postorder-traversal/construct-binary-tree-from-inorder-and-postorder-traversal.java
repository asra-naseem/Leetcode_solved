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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       
        Map<Integer,Integer> in = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
         in.put(inorder[i],i);

        TreeNode root = helper(postorder,postorder.length-1,in,0,inorder.length-1);
        return root;
    }
    public TreeNode helper(int [] postorder,int inRoot,Map<Integer,Integer> in,int inStart,int inEnd){
        if(inStart>inEnd)
        return null;
        TreeNode root = new TreeNode(postorder[inRoot]);
        int mid = in.get(postorder[inRoot]);
        if(mid>inStart)
        root.left = helper(postorder,inRoot-(inEnd-mid+1),in,inStart,mid-1);
        root.right = helper(postorder,inRoot-1,in,mid+1,inEnd);
        return root;
        
    
    }
}
