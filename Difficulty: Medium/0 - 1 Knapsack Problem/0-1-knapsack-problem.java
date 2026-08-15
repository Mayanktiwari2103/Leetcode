class Solution {
    private int generate(int ind , int[] val , int[] wt , int W , int[][] dp){
        if(ind==0){
            if(wt[ind] <= W){
                return val[ind];
            }
            return  0;
        }
        if(dp[ind][W]!=-1) return dp[ind][W];
        int notpick=generate(ind-1, val, wt, W, dp);
        int pick=0;
        if(wt[ind] <= W){
            pick=val[ind] + generate(ind-1, val , wt, W-wt[ind], dp);
        }
        
        return dp[ind][W]=Math.max(pick,notpick);
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        int[][] dp=new int[n][W+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=W;j++){
                dp[i][j]=-1;
            }
        }
        return generate(n-1 , val ,wt , W , dp);
    }
}
