class Solution {
	
	private int generate(int[] arr , int ind, int target , int[][] dp){
	    if(ind==0){
	        if(arr[ind]==0 && target==0) return 2;
	        
	        if(target==0 || arr[ind]==target) return 1;
	        return 0;
	    }
	    if(dp[ind][target]!=-1) return dp[ind][target];
        int not=generate(arr, ind-1, target, dp);
        int pick=0;
        if(arr[ind] <= target){
            pick=generate(arr , ind-1, target-arr[ind] , dp);
        }
        return dp[ind][target]=not+pick;
	}
	public int countPartitions(int[] arr, int diff) {
		// code here
	    int n=arr.length;
	    int sum=0;
	    for(int x:arr){
	        sum+=x;
	    }
	    int target=(diff+sum)/2;
	    if((diff +sum) %2 ==1) return 0; 
	    int[][] dp=new int[n][target+1];
        for(int[] row:dp){
           Arrays.fill(row,-1);
        }
        
        return generate(arr , n-1 , target , dp);
	    
	}
}
