class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int lsum=0;
        int rsum=0;
        int l=0;
        int maxsum=0;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
            maxsum=lsum;
        }
        int r=n-1;
        for(int i=k-1;i>=0;i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[r];
            r--;
            maxsum=Math.max(maxsum,rsum+lsum);
        }
        return maxsum;

        
    }
}