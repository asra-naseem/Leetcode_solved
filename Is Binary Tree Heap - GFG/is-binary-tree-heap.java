//{ Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

  public class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();
            if (ob.isHeap(root))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


// User Function template for JAVA

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    public int countNodes(Node root){
        if(root==null)
        return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public boolean isCBT(Node r,int c,int i ){
        if(r==null)
        return true;
        if(i>=c)
        return false;
        else
        return isCBT(r.left,c,2*i+1)&& isCBT(r.right,c,2*i+2);

    }
    public boolean isCompleteTree(Node root) {
        int count= countNodes(root);
        if(isCBT(root,count,0)==true)
        return true;
        else
        return false;
    }
    boolean isMax(Node root){
        
        if(root.left==null && root.right==null)
        return true;
        if(root.right==null)
        {
             return (root.left.data<root.data);
            
        }
        
            return (root.data>root.left.data && root.data >root.right.data) &&isMax(root.left)&&isMax(root.right);
    
    }
    boolean isHeap(Node tree) {
        // code here
        if(isCompleteTree(tree)&& isMax(tree)){
          // System.out.println(isCompleteTree(tree));
           return true;
        }
    
    
        return false;
    }
}