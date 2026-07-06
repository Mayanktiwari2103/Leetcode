class Solution {
    private int generate(int[][] matrix, int i,int j, int[][] dp){
        if(j<0 || j>=matrix[0].length) return Integer.MAX_VALUE;
        if(i==0) return matrix[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        int topup=matrix[i][j] + generate(matrix,i-1,j,dp);
        int topleft= generate(matrix,i-1,j-1,dp);
        if(topleft!=Integer.MAX_VALUE){
            topleft+=matrix[i][j];
        }
        int topright= generate(matrix,i-1,j+1,dp);
        if(topright!=Integer.MAX_VALUE){
            topright+=matrix[i][j];
        }
        int mini=Math.min(topup,topleft);
        return dp[i][j]=Math.min(mini,topright);
    }
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
          ans=Math.min(ans,generate(matrix,m-1,j,dp));
        }
        return ans;

    }
}