class Solution {
    private int generate(int ind, int val[] , int wt[] , int target,int[][] dp){
        if(ind==0){
             return dp[ind][target]=(target / wt[ind])*val[ind];
        }
        if(dp[ind][target]!=-1) return dp[ind][target];
        int not=generate(ind-1,val,wt,target,dp);
        int take=0;
        if(target >= wt[ind]){
            take=val[ind] + generate(ind,val,wt,target-wt[ind],dp);
        }
        
        return dp[ind][target] = Math.max(take,not);
    }
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n=wt.length;
        int[][] dp=new int[n][capacity+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return generate(n-1,val,wt,capacity,dp);
    }
}