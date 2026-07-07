class Solution {
    private boolean generate(int[] nums, int ind,int target,int[][] dp){
        if(target==0){
            return true;
        }
        if(ind==0) return nums[ind]==target;
        if(dp[ind][target]!=-1) return dp[ind][target]==1;
        boolean not=generate(nums,ind-1,target,dp);
        boolean take=false;
        if(target >= nums[ind]){
            take=generate(nums,ind-1,target-nums[ind],dp);
        }
        dp[ind][target]= (take || not) ?1:0 ;
        return take || not;
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
           sum+=nums[i];
        }
        int[][] dp=new int[n][(sum/2)+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        if(sum%2!=0) return false;
        return generate(nums,n-1,sum/2,dp);
        

    }
}