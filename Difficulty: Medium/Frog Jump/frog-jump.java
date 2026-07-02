class Solution {
    private int generate(int ind,int[] dp,int[] heights){
        if(ind==0){
            return 0;
        }
        if(dp[ind]!=-1) return dp[ind];
        int left=generate(ind-1,dp,heights)+Math.abs(heights[ind]-heights[ind-1]);
        int right=Integer.MAX_VALUE;
        if(ind>1) {
            right=generate(ind-2,dp,heights)+Math.abs(heights[ind]-heights[ind-2]);
        }    
        
        return dp[ind]=Math.min(left,right);
        
    }
    int minCost(int[] height) {
        // code here
        int n=height.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return generate(n-1,dp,height);
        
    }
}