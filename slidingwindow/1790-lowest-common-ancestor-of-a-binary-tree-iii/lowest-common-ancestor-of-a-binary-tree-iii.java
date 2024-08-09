/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
       Node root= findRoot(p);
       return LCA(root,p,q);
        
    }
    public Node findRoot(Node p){
        while(p.parent!=null){
            p=p.parent;
        }
        return p;
    }
    public Node LCA(Node root,Node p,Node q){
        if(root==null || root==p || root==q)
        return root;
        Node left =LCA(root.left,p,q);
        Node right=LCA(root.right,p,q);
        if(left==null)
        return right;
        if(right==null)
        return left;
        return root;
    }
}