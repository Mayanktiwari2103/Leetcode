class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int maxlen=1;
        int[] cnt=new int[n];
        Arrays.fill(cnt,1);
        for(int i=1;i<n;i++){
            for(int prev=0;prev< i ;prev++){
              if(nums[prev] < nums[i]){
                if(dp[i] <  dp[prev]+1){
                    dp[i]=dp[prev]+1;
                    cnt[i]=cnt[prev];
                }
                else if(dp[prev] + 1 == dp[i]){
                    cnt[i]+=cnt[prev];
                }
              }
            }
            if(dp[i] > maxlen){
              maxlen=dp[i];
            }
        }
        int cnt1=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxlen){
              cnt1+=cnt[i];
            }
        }

        return cnt1;
    }
}