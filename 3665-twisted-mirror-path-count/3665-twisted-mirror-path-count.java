class Solution {
    long mod = (int)1e9 + 7;
    private int generate(int[][] grid, int i, int j , int d,int[][][] dp){
        int n=grid.length;
        int m=grid[0].length;

        if(i>=n || j>=m) return 0;
        if(i==n-1 && j==m-1) return 1;
        if(dp[i][j][d]!=-1) return dp[i][j][d];

        if(grid[i][j]==1){
            if(d==0){
                return dp[i][j][d]=generate(grid,i+1,j,1,dp);
            }
            else{
                return dp[i][j][d]=generate(grid,i,j+1,0,dp);
            }
        }
        
        return dp[i][j][d] = (int)(
    ((long)generate(grid,i+1,j,1,dp) +
    generate(grid,i,j+1,0,dp)) % mod);        
        
    }
    public int uniquePaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][2];
        for (int[][] k : dp)
            for (int[] l : k)
                Arrays.fill(l, -1);

        return generate(grid,0,0,0,dp);
    }
}