//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{   public static Node reverseLL(Node head){
      Node prev=null;
      Node curr= head;
      Node nex=head;
      while(curr!=null){
          nex=curr.next;
          curr.next=prev;
          prev=curr;
          curr=nex;
      }
      return prev;
    }
    public static Node addOne(Node head) 
    { 
        //code here.
        Node rL= reverseLL(head);
        Node curr = rL;
        int carry=1;
        while(curr!=null && carry!=0){
            int sum= curr.data+carry;
            curr.data=sum%10;
            carry= sum/10;
            if(curr.next==null && carry==1){
                curr.next=new Node(carry);
                carry=0;
            }
            curr=curr.next;
        }
        return reverseLL(rL);
        
    }
}
