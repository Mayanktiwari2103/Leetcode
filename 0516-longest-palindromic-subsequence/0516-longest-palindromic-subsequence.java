class Solution {
    private int generate(String text1 , String text2 , int i , int j , int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            return dp[i][j]=1+generate(text1, text2 , i-1 , j-1 , dp);
        }
        return dp[i][j]=Math.max(generate(text1, text2, i-1,j,dp), generate(text1,text2,i,j-1,dp));

    } 
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        StringBuilder s2=new StringBuilder(s);
        s2=s2.reverse();
        int m=s2.length();
        int[][] dp=new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return generate(s,s2.toString(),n-1,m-1,dp);
        
    }
}