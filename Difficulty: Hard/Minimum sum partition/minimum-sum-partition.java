class Solution {
	
	private static boolean generate(int[][] dp, int[] arr, int ind, int sum) {
		
		if (sum == 0)
			return true;
		
		if (ind == 0)
			return arr[0] == sum;
		
		if (dp[ind][sum] != -1)
			return dp[ind][sum] == 1;
		
		boolean not = generate(dp, arr, ind - 1, sum);
		
		boolean take = false;
		if (sum >= arr[ind]) {
			take = generate(dp, arr, ind - 1, sum - arr[ind]);
		}
		
		dp[ind][sum] = (take || not) ? 1 : 0;
		
		return take || not;
	}
	
	public int minDifference(int arr[]) {
		
		int n = arr.length;
		
		int sum = 0;
		for (int x : arr)
			sum += x;
		
		int[][] dp = new int[n][sum + 1];
		
		for (int[] row : dp)
			Arrays.fill(row, -1);
		
		// Fill memoization table
		for (int s = 0; s <= sum; s++) {
			generate(dp, arr, n - 1, s);
		}
		
		int mini = Integer.MAX_VALUE;
		
		for (int s1 = 0; s1 <= sum/2; s1++) {
			if (generate(dp, arr, n - 1, s1)) {
				mini = Math.min(mini, Math.abs(sum - 2 * s1));
			}
		}
		
		return mini;
	}
}
