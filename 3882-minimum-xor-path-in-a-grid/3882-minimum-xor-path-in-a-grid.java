class Solution {

    private Set<Integer> generate(int[][] grid, int i, int j,Set<Integer>[][] dp){
        if(i<0 || j<0) return new HashSet<>();
        if(i==0 && j==0){
            Set<Integer> set = new HashSet<>();
           set.add(grid[0][0]);
           return set;
        }
        if(dp[i][j]!=null) return dp[i][j];
        
        Set<Integer> result=new HashSet<>();
        Set<Integer> left=generate(grid,i,j-1,dp);
        Set<Integer> up=generate(grid,i-1,j,dp);
        
        for(int val:left){
            result.add(grid[i][j]^val);
        }

         for(int val:up){
            result.add(grid[i][j]^val);
        }
        
        return dp[i][j]=result;
        
    }
    public int minCost(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Set<Integer>[][] dp = new HashSet[n][m];

        Set<Integer> result = generate(grid, n - 1, m - 1, dp);

        int ans = Integer.MAX_VALUE;

        for (int val : result) {
            ans = Math.min(ans, val);
        }

        return ans;
    }


}