class Solution {
    private int generate(int[] coins , int amount,int ind,int[][] dp){
        if(ind==0){
            if(coins[ind]==amount){
                return 1;
            }
            else if(amount % coins[ind]==0){
                return amount/ coins[ind];
            }

            return (int)(1e9);
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int not=generate(coins,amount,ind-1,dp);
        int take=(int)(1e9);
        if(amount>=coins[ind]){
            take=1+generate(coins,amount-coins[ind],ind,dp);
        }

        return dp[ind][amount]=Math.min(take,not);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ans=generate(coins,amount,n-1,dp);
        return ans>=(int)(1e9)?-1:ans;

    }
}