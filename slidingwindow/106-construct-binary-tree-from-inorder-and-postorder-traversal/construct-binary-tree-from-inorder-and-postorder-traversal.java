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

        TreeNode root = helper(postorder,0,postorder.length-1,in,0,inorder.length-1);
        return root;
    }
    public TreeNode helper(int [] postorder,int posStart,int posEnd,Map<Integer,Integer> in,int inStart,int inEnd){
        if (posStart > posEnd || inStart > inEnd) {
        return null;
    }
    TreeNode root = new TreeNode(postorder[posEnd]);
    int inRoot = in.get(postorder[posEnd]);
    int leftTreeSize = inRoot - inStart;

    root.left = helper(postorder, posStart, posStart + leftTreeSize-1 , in, inStart, inRoot - 1);
    root.right = helper(postorder, posStart + leftTreeSize, posEnd - 1, in, inRoot + 1, inEnd);
    return root;
        
    }
    }
