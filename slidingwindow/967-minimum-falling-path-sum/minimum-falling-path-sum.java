// class Solution {
//     int dp[][];
//     public int minFallingPathSum(int[][] matrix) {
//         int m = matrix.length;
//         int n= matrix[0].length;
//         dp=new int[m][n];
//         for(int i=0;i<m;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         int ans = Integer.MAX_VALUE;
//         for(int j=0;j<n;j++)
//         {
//             ans= Math.min(ans,findMin(0,j,matrix,dp));
//         }
//         return ans;
        
//     }
//     public int findMin(int x,int y , int [][] matrix,int [][]dp){
        
        
//         if(y<0 || y>matrix[0].length-1)
//         return Integer.MAX_VALUE;
//         if(x==matrix.length-1)
//         return matrix[x][y];
//         if(dp[x][y]!=-1)
//         return dp[x][y];
//         int left = findMin(x+1,y-1,matrix,dp);
//         int right = findMin(x+1,y+1,matrix,dp);
//         int down = findMin(x+1,y,matrix,dp);
//         dp[x][y]=Math.min(down,Math.min(left,right))+matrix[x][y];
//         return dp[x][y];
//     }
// }
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int minFallingSum = Integer.MAX_VALUE;
        Integer memo[][] = new Integer[matrix.length][matrix[0].length];

        // start a DFS (with memoization) from each cell in the top row
        for (int startCol = 0; startCol < matrix.length; startCol++) {
            minFallingSum = Math.min(minFallingSum,
                findMinFallingPathSum(matrix, 0, startCol, memo));
        }
        return minFallingSum;
    }

    public int findMinFallingPathSum(int[][] matrix, int row, int col, Integer[][] memo) {
        //base cases
        if (col < 0 || col == matrix.length) {
            return Integer.MAX_VALUE;
        }
        //check if we have reached the last row
        if (row == matrix.length - 1) {
            return matrix[row][col];
        }
        //check if the results are calculated before
        if (memo[row][col] != null) {
            return memo[row][col];
        }

        // calculate the minimum falling path sum starting from each possible next step
        int left = findMinFallingPathSum(matrix, row + 1, col, memo);
        int middle = findMinFallingPathSum(matrix, row + 1, col + 1, memo);
        int right = findMinFallingPathSum(matrix, row + 1, col - 1, memo);

        memo[row][col] = Math.min(left, Math.min(middle, right)) + matrix[row][col];
        return memo[row][col];
    }
}