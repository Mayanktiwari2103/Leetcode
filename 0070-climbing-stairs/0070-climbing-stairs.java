class Solution {
    private int count(int ind ,int[] dp){
        if(ind<0) return 0;
        if(ind==0) return 1;
        if(dp[ind]!=-1) return dp[ind];
        int one=count(ind-1,dp);
        int two=count(ind-2,dp);
        return dp[ind]=one+two;
    }
    public int climbStairs(int n) {
       int[] dp=new int[n+1];
       Arrays.fill(dp,-1);
       return count(n,dp);
    }
}