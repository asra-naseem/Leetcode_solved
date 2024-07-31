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
    public boolean isLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }
    List<Integer> res = new ArrayList<>();
    public void addLeftBoundary(TreeNode node){
        TreeNode curr = node.left;
        while(curr!=null){
            if(isLeaf(curr)==false)
            res.add(curr.val);
            if(curr.left!=null)
            curr=curr.left;
            else
            curr=curr.right;
        }
    }
    public void addRightBoundary(TreeNode node){
        ArrayList<Integer> arr = new ArrayList<>();
        TreeNode curr = node.right;
        while(curr!=null){
            if(isLeaf(curr)==false)
            arr.add(curr.val);
            if(curr.right!=null)
            curr=curr.right;
            else
            curr=curr.left;
        }
        for(int i=arr.size()-1;i>=0;i--)
         res.add(arr.get(i));
    }
    public void addLeafNodes(TreeNode node){
        if (node == null) return;
        if (isLeaf(node)) {
            res.add(node.val);
            return;
        }
        addLeafNodes(node.left);
        addLeafNodes(node.right);
       
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return res;
        }
        
        if (!isLeaf(root)) 
            res.add(root.val);
        
        
        addLeftBoundary(root);
        addLeafNodes(root);
        
        addRightBoundary(root);
        return res;
        
    }
}