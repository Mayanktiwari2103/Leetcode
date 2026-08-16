class Solution {
    private static int generate(int[] arr ,int ind , int target , int[][] dp){
        
        if(ind==0){
            if(target==0 && arr[ind]==0){
                return 2;
            }
            if(arr[ind]==target || target==0){
                return 1;
            }
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
    static int perfectSum(int[] arr, int target) {
        // code here
        int n=arr.length;
        int[][] dp=new int[n][target+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return generate(arr , n-1 , target , dp);
     }
}