class Solution {
    private static boolean generate(int[][] dp,int[] arr, int ind, int sum){
        if(sum==0) return true;
        if(ind==0) return arr[0]==sum;
        if(dp[ind][sum]!=-1) return dp[ind][sum]==1;
        boolean not=generate(dp,arr,ind-1,sum);
        boolean take=false;
        if(sum>=arr[ind]){
            take=generate(dp,arr,ind-1,sum-arr[ind]);
        }
        
        dp[ind][sum]=(take || not)?1:0;
        return take||not;
        
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        int[][] dp=new int[n][sum+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return generate(dp,arr,n-1,sum);
    }
}