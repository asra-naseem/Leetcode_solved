class Solution {
    public int maxScore(int[] c, int k) {
       int sum =0;
       int maxSum=0;
        for(int i=0;i<k;i++){
            sum =sum +c[i];
        }
        maxSum = Math.max(sum,maxSum);
        int lindex=k-1,rindex= c.length-1;
        while(lindex>=0){
           sum = sum - c[lindex];
           lindex--;
           sum = sum+c[rindex];
           rindex--;
           maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
        
    }
}