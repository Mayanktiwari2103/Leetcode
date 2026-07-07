class Solution {
	// Function to calculate the number of subsets with a given sum
	private int generate(int[] nums, int ind, int target, int[][] dp) {
	
		if (ind == 0) {
			
			if (target == 0 && nums[0] == 0)
				return 2;
			
			if (target == 0 || nums[0] == target)
				return 1;
			
			return 0;
		}
		if (dp[ind][target] != -1)
			return dp[ind][target];
		int not = generate(nums, ind - 1, target, dp);
		int take = 0;
		if (target >= nums[ind]) {
			take = generate(nums, ind - 1, target - nums[ind], dp);
		}
		
		return dp[ind][target] = take + not;
	}
	public int perfectSum(int[] nums, int target) {
		// code here
		int n = nums.length;
		int[][] dp = new int[n][target + 1];
		for (int[] row:dp) {
			Arrays.fill(row, -1);
		}
		return generate(nums, n - 1, target, dp);
	}
}
