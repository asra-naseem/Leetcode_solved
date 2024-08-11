class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n= matrix[0].length;
        // dp=new int[m][n];
        // for(int i=0;i<m;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        Integer dp[][] = new Integer[matrix.length][matrix[0].length];
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
        {
            ans= Math.min(ans,findMin(0,j,matrix,dp));
        }
        return ans;
        
    }
    public int findMin(int x,int y , int [][] matrix,Integer [][]dp){
        
        
        if(y<0 || y>matrix[0].length-1)
        return Integer.MAX_VALUE;
        if(x==matrix.length-1)
        return matrix[x][y];
        if(dp[x][y]!=null)
        return dp[x][y];
        int left = findMin(x+1,y-1,matrix,dp);
        int right = findMin(x+1,y+1,matrix,dp);
        int down = findMin(x+1,y,matrix,dp);
        dp[x][y]=Math.min(down,Math.min(left,right))+matrix[x][y];
        return dp[x][y];
    }
}
