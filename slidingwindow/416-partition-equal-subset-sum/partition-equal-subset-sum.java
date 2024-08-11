class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;

        for(int i=0;i<nums.length;i++)
         sum  = sum+nums[i];

        if(sum%2 != 0)
        return false;
        Integer [][]dp = new Integer[201][20001];

        if(findPartition(nums,nums.length-1,sum/2,dp)==0)
        return false;
        return true;
        
    }
    public int findPartition(int [] nums,int index,int target,Integer[][]dp){
        if(index ==0)
        {
            if(target == nums[0])
            return 1;
            return 0;
        }
        if(target ==0)
        return 1;
        if(dp[index][target]!=null)
        return dp[index][target];
        int nottake = (int)findPartition(nums,index-1,target,dp);
        int take =0;
        if(target>nums[index])
        take = (int)findPartition(nums,index-1,target-nums[index],dp);
        if(take+nottake !=0)
        dp[index][target]= 1;
        else
        dp[index][target]= 0;
        return dp[index][target];

    }
}