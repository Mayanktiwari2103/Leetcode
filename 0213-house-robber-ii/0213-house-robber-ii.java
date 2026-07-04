class Solution {

    private int generate(int[] nums){
        int n = nums.length;

        if(n == 1)
            return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if(n==1)
            return nums[0];

        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];

        for(int i=1;i<n;i++)
            temp1[i-1] = nums[i];

        for(int i=0;i<n-1;i++)
            temp2[i] = nums[i];

        return Math.max(generate(temp1), generate(temp2));
    }
}