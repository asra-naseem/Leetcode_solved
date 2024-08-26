class Solution {
    public int[] replaceElements(int[] arr) {
        int maxi = -1;
        int current ;
        for(int i=arr.length-1;i>=0;i--){
            current = arr[i];
            arr[i]=maxi;
            if(current > maxi)
             maxi=current;
        }

        return arr;
    }
}