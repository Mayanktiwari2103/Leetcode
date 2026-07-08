class Solution {
	private int generate(int[] arr, int target, int ind, int[][] dp) {
		if (ind == 0) {
		    if(target==0 && arr[ind]==0){
		        return 2;
		    }
			if (target == 0 || arr[ind] == target) {
				return 1;
			}
			return 0;
		}
		if (dp[ind][target] != -1)
			return dp[ind][target];
		int not = generate(arr, target, ind - 1, dp);
		int take = 0;
		if (target >= arr[ind]) {
			take = generate(arr, target - arr[ind], ind - 1, dp);
		}
		
		return dp[ind][target] = take + not;
		
	}
	public int countPartitions(int[] arr, int diff) {
		// code here
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i<n; i++) {
			sum += arr[i];
		}
		if (sum - diff < 0)
			return 0;
		if ((sum - diff) % 2 != 0)
			return 0;
		int target = (sum - diff)/2;
		int[][] dp = new int[n][target + 1];
		for (int[] row:dp) {
			Arrays.fill(row, -1);
		}
		
		return generate(arr, target, n - 1, dp);
		
	}
}
