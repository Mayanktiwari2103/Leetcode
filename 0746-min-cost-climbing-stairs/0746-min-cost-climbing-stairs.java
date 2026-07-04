class Solution {
    private int generate(int[] cost,int[] dp,int ind){
        if(ind<=1) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int left=generate(cost,dp,ind-1)+cost[ind-1];
        int right=Integer.MAX_VALUE;
        if(ind>1) right=generate(cost,dp,ind-2)+cost[ind-2];

        return dp[ind]=Math.min(left,right);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return generate(cost,dp,n);
    }
}