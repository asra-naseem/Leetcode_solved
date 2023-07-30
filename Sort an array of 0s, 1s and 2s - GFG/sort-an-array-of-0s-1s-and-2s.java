//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{  
    public static void swap(int a[],int i,int x){
    int temp=a[i];
    a[i]=a[x];
    a[x]=temp;
}
    public static void sort012(int a[], int n)
    {
        // code here 
        int curr=0;
        int left=0;
        int right=n-1;
        while(curr<=right){
            if(a[curr]==0){
                swap(a,curr,left);
                left++;
                curr++;
            }
            else if(a[curr]==2){
                swap(a,curr,right);
                right--;
            }
            else
            curr++;
        }
            
        
    }
}


//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends