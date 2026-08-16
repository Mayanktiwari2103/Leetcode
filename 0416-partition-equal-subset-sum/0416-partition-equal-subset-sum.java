class Solution {    
    private boolean generate(int[] nums , int ind , int sum , int[][] dp){
        if(sum==0) return true;
        if(ind==0){
           if(nums[ind]==sum){
            return true;
           }
           return false;
        }
        if(dp[ind][sum]!=-1) return dp[ind][sum]==1;
        boolean not=generate(nums, ind-1,sum,dp);
        boolean take=false;
        if(nums[ind] <= sum){
            take=generate(nums, ind-1 , sum-nums[ind],dp);
        }
        dp[ind][sum]=not || take ?1:0;
        return not || take;
    }    
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;
        int[][] dp=new int[n][(sum/2)+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=sum/2;j++){
                dp[i][j]=-1;
            }
        }

        return generate(nums , n-1, sum/2, dp);
    }
}