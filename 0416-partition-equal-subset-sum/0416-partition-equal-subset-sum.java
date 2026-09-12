class Solution {   
    private boolean generate(int[] nums, int ind , int target, int[][] dp){
        if(target==0) return true;
        if(ind==0){
           if(target==nums[ind]){
            return true;
           }
           return false;
        }
        if(dp[ind][target]!=-1) return dp[ind][target]==1;
        boolean not=generate(nums, ind-1,target,dp);
        boolean take=false;
        if(nums[ind]<=target){
            take=generate(nums, ind-1,target-nums[ind],dp);
        }
        dp[ind][target]=not || take?1:0;
        return not || take;
    } 
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if(sum%2==1) return false;
        int[][] dp=new int[n][(sum/2)+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return generate(nums, n-1, sum/2,dp);
    }
}