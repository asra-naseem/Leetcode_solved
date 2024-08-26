class Solution {
    int total = 0;
    public int numEnclaves(int[][] grid) {
        int nOnes = 0;
        total=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
            if(grid[i][j]==1)
            nOnes++;
        }
        int [][] vis = new int [grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
            {
                vis[i][j]=0;
            }
        }
        int drow[]= {0,0,-1,1};
        int dcol[] = {1,-1,0,0};
        
           for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
            {
                if(i==0 || j==0 || i==(grid.length-1)|| j==(grid[0].length-1))
                {
                    if(grid[i][j]==1 && vis[i][j]==0)

                    {   
                        dfs(i,j,vis,grid,drow,dcol);
                    }
                }
            }

        }
        return nOnes-total;
    }
    public void dfs(int row,int col,int[][] vis,int[][] grid,int[] drow,int[]dcol){
        total++;
        vis[row][col] = 1;
        for(int i=0;i<4;i++){
            int nrow = row + drow[i];
            int ncol = col+dcol[i];
            if(nrow>=0 && nrow <grid.length && ncol >= 0 && ncol <grid[0].length && vis[nrow][ncol]==0 && grid[nrow][ncol] ==1){
               
                dfs(nrow,ncol,vis,grid,drow,dcol);

            }
        }
    }
}