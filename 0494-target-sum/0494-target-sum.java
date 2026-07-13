class Solution {
    private int generate(int[] nums, int find , int ind,int[][] dp){
        if(ind==0){
            if(find==0 && nums[0]==0) return 2;
            if(find==0 || find==nums[0]) return 1;
            return 0;
        }
        if(dp[ind][find]!=-1) return dp[ind][find];
        int not=generate(nums,find,ind-1,dp);
        int take=0;
        if(find >= nums[ind]){
            take=generate(nums,find-nums[ind],ind-1,dp);
        }

        return dp[ind][find]=not+take;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int i=0; i<n ;i++){
          sum+=nums[i];
        }
        if(Math.abs(target) > sum)
            return 0;
        if((sum+target) %2 !=0) return 0;
        int[][] dp=new int[n][sum+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return generate(nums,(sum+target)/2,n-1,dp);

    }
}