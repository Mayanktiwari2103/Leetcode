class Solution {
    private int generate(int mat[][],int[][] dp,int day,int last){
        if(day==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxi=Math.max(maxi,mat[0][i]);
                }
            }
            return maxi;
        }
        if (dp[day][last] != -1)
            return dp[day][last];
        
        int maxi=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                int point=mat[day][i]+generate(mat,dp,day-1,i);
                maxi=Math.max(maxi,point);
            }
        }
        
        return dp[day][last]=maxi;
    }
    public int maximumPoints(int mat[][]) {
        // code here
        int n=mat.length;
        int[][] dp=new int[n][4];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return generate(mat,dp,n-1,3);
    }
    
}