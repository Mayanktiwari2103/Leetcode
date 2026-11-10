class Solution {
    private int generate(int[] costs, int ind,int n,int[] dp){
        if(ind==n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int one=Integer.MAX_VALUE;
        if(ind+1<=n){
          one=costs[ind] + 1 +generate(costs,ind+1,n,dp);
        }
        int two=Integer.MAX_VALUE;
        if(ind+2<=n){
          two= costs[ind+1] + 4 + generate(costs,ind+2,n,dp);
        }
        int three=Integer.MAX_VALUE;
        if(ind+3<=n){
           three= costs[ind+2] + 9 + generate(costs,ind+3,n,dp);
        }

        return dp[ind]=Math.min(one,Math.min(two,three));
    }
    public int climbStairs(int n, int[] costs) {
        int m=costs.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return generate(costs,0,n,dp);
    }
}