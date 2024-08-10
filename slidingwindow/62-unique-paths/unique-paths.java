class Solution {
    int [][]dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
       for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
       return finduniquePaths(dp,m-1,n-1);

        
    }
    public int finduniquePaths(int[][]dp,int x,int y){
      if(x==0 && y==0)
      return 1;
      if(x<0 || y<0)
      return 0;
      if(dp[x][y]!=-1)
        return dp[x][y];
     int left = finduniquePaths(dp,x-1,y);
     int right = finduniquePaths(dp,x,y-1);
     dp[x][y]=left+right;
     return dp[x][y];
    }
}