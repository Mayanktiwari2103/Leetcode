class Solution {
    private int generate(int[] coins , int amount , int ind , int[][] dp){
        if(ind==0){
           if(amount % coins[ind]==0){
            return amount/coins[ind];
           }
           return (int) 1e9;
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int notpick=generate(coins,amount,ind-1,dp);
        int pick=(int) 1e9;
        if(coins[ind] <= amount){
            pick=1+generate(coins , amount-coins[ind], ind,dp);
        }
        
        return dp[ind][amount]=Math.min(notpick,pick);

    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        int ans=generate(coins,amount,n-1,dp);
        return ans>=(int) 1e9?-1:ans;
        
    }
}