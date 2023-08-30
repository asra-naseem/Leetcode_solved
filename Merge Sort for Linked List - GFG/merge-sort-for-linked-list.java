//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    public static Node getmid(Node root){
        Node prev=null;
        Node fast= root;
        while(fast!=null && fast.next!=null){
            if(prev==null){
                prev=root;
            }
            else
            prev=prev.next;
            fast=fast.next.next;
        }
        Node mid= prev.next;
        prev.next=null;
        return mid;
    }
    static Node mergeSort(Node head)
    {
        // add your code here
         if(head==null|| head.next==null)
        return head;
        Node mid = getmid(head);
        Node left = mergeSort(head);
        Node right =mergeSort(mid);
        return merge(left,right);
    }
     
     public static Node merge(Node L1,Node L2){
        Node dummy=new Node(-1);
        Node tail= dummy;
        while(L1!=null && L2!=null){
            if(L1.data<L2.data){
                tail.next=L1;
                L1=L1.next;
                
            }
            else{
                tail.next=L2;
                L2=L2.next;
               // tail=tail.next;
            }
            tail=tail.next;
        }
        if(L1!=null){
            tail.next=L1;
        }
        else
        tail.next=L2;
        return dummy.next;
    }
}



