//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    static Node reverseLL(Node root){
        Node prev=null;
        Node nex=root;
        Node curr=root;
        while(curr!=null){
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        return prev;
    }
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        Node res= new Node(-1);
        Node curr=res;
        Node rL1= reverseLL(first);
        Node rL2= reverseLL(second);
        
        int carry=0,sum=0;
        while(rL1!=null && rL2!=null){
        sum=(rL1.data+rL2.data+carry);
       // System.out.println(rL1.data+""+rL2.data+" "+sum);
        carry=sum/10;
        res.next=new Node(sum%10);
        //System.out.println("res"+res.next.data);
        res=res.next;
       // System.out.println(carry+" "+sum+""+res.next.data);                                                                                                                                                                                                                                                                                                                                              
        rL1=rL1.next;
        rL2=rL2.next;
        }
        while(rL1!=null){
            if(carry==0){
                res.next=new Node(rL1.data);
                
            }
            else
            {
            sum = (carry+rL1.data);
            res.next=new Node(sum%10);
            carry=sum/10;
            
            }
            
            rL1=rL1.next;
            res=res.next;
        }
        while(rL2!=null){
            if(carry==0){
                res.next=new Node(rL2.data);
                
            }
            else{
            sum = (carry+rL2.data);
            res.next=new Node(sum%10);
            carry=sum/10;}
            rL2=rL2.next;
            res=res.next;
        }
        if(carry!=0)
        res.next=new Node(carry);
       // res=res.next;
      // System.out.println("res"+res.next.data+""+curr.next.data);
        
      return reverseLL(curr.next);  
        
    }
}