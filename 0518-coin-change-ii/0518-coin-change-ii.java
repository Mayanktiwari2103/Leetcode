class Solution {
    private int generate(int amount, int[] coins , int ind,int[][] dp){
        if(ind==0){
            if(amount % coins[ind]==0 ){
                return 1;
            }

            return 0;
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int not=generate(amount,coins,ind-1,dp);
        int take=0;
        if(amount>=coins[ind]){
            take=generate(amount-coins[ind],coins,ind,dp);
        }

        return dp[ind][amount]=take+not;

    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return generate(amount,coins,n-1,dp);
    }
}