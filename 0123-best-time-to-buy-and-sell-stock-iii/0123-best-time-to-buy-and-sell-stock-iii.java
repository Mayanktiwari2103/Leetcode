class Solution {
    private int generate(int[] prices,int ind , int buy ,int rem,int[][][] dp){
        if(ind==prices.length || rem==0) return 0;
        int profit=0;
        if(dp[ind][buy][rem]!=-1) return dp[ind][buy][rem];
        if(buy==1){
          profit=Math.max(-prices[ind]+generate(prices,ind+1,0,rem,dp), 0+generate(prices,ind+1,1,rem,dp));
        }
        else{
            profit=Math.max(prices[ind]+generate(prices,ind+1,1,rem-1,dp) , 0+generate(prices,ind+1,0,rem,dp));
        }

        return dp[ind][buy][rem]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return generate(prices,0,1,2,dp);
        
    }
}