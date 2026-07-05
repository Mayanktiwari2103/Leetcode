class Solution {
    private int generate(int[][] dp, int i , int j,int[][] obstacleGrid){
        if(i==0 && j==0 && obstacleGrid[i][j]!=1) return 1;
        if(i<0 || j<0) return 0;
        if(obstacleGrid[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=generate(dp,i-1,j,obstacleGrid);
        int left=generate(dp,i,j-1,obstacleGrid);

        return dp[i][j]=up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return generate(dp,m-1,n-1,obstacleGrid);
    }
}