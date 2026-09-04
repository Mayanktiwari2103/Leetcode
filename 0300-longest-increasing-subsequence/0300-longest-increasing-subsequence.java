class Solution {
    private int generate(int[] nums , int ind,int prev,int[][] dp){
        if(ind==nums.length) return 0;
        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        int not=generate(nums,ind+1,prev,dp);
        int take=0;
        if(prev==-1 || nums[prev] < nums[ind]){
            take=1+generate(nums,ind+1, ind,dp);
        }

        return dp[ind][prev+1]=Math.max(not,take);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }

        return generate(nums,0,-1,dp);
    }
}