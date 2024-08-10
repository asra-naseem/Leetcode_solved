class Solution {
    int [][]dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =obstacleGrid.length;
        int n = obstacleGrid[0].length;
         dp = new int[m][n];
       for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        
       return finduniquePaths(dp,m-1,n-1,obstacleGrid);

        
    }
    public int finduniquePaths(int[][]dp,int x,int y,int[][]grid){
      if(x==0 && y==0){
      if(grid[x][y]==1)
      return 0;
      else
      return 1;
      }
      
      if(x<0 || y<0 || grid[x][y]==1)
      return 0;
      if(dp[x][y]!=-1)
        return dp[x][y];
     int left = finduniquePaths(dp,x-1,y,grid);
     int right = finduniquePaths(dp,x,y-1,grid);
     dp[x][y]=left+right;
     return dp[x][y];
    }
}