class Solution {
    public int maxProfit(int[] prices) {
        int maxpro=0;
        int prevstock=prices[0];
      int currstock=0;
        for(int i=1;i<prices.length;i++){
            if(prevstock<prices[i])
            {
                if(maxpro<prices[i]-prevstock)
                maxpro=prices[i]-prevstock;
                
            }
            if(prevstock>prices[i])
                prevstock=prices[i];
        }
        
        return maxpro;

    }
}