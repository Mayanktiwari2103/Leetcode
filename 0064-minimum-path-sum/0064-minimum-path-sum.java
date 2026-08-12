class Solution {
    private int count(int[][] grid, int i , int j , int[][] dp){
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int left= count(grid, i,j-1,dp);
        int up= count(grid, i-1,j,dp);

        return dp[i][j]=grid[i][j] + Math.min(left,up);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return count(grid,n-1,m-1,dp);

    }
}