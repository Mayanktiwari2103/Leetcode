class Solution {
    private static int generate(int[] arr,int i , int j, int[][] dp){
        if(i==j) return 0;
        int mini=Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        
        for(int k=i;k<j;k++){
            int steps=arr[i-1]*arr[k]*arr[j] + generate(arr,i,k,dp)+ generate(arr,k+1,j,dp);
            
            mini=Math.min(steps,mini);
        }
        
        return dp[i][j]=mini;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return generate(arr,1,n-1,dp);
        
    }
}