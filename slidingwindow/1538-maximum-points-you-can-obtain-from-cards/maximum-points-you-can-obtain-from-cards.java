class Solution {
    public int maxScore(int[] c, int k) {
        int lsum=0;
        for(int i=0;i<k;i++)
        lsum=c[i]+lsum;
        int sum=lsum;
        int j=c.length-1;
        int rsum=0;

        for(int i=k-1;i>=0;i--){
            lsum=lsum-c[i];
            rsum=rsum+c[j];
            j--;
            sum=Math.max(sum,lsum+rsum);
        }
        return sum;
        
    }
}