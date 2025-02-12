class Solution {
    public int calMaxProfit(int[] prices ,int [][] dp, int index,int buy){
        if(index == prices.length)
        return 0;

        if(dp[index][buy]!=-1)
        return dp[index][buy];

        int profit =0;
        if(buy==1)
        profit = Math.max(-1*prices[index]+calMaxProfit(prices,dp,index+1,0),0+calMaxProfit(prices,dp,index+1,1));
        else
        profit = Math.max(prices[index]+calMaxProfit(prices,dp,index+1,1),0+calMaxProfit(prices,dp,index+1,0));

       dp[index][buy]=profit;
       return profit;

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if(n==0)
        return 0;
       int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
       return  calMaxProfit(prices,dp,0,1);
        
    }
}