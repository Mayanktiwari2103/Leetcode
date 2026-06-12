class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=0;
        int maxlen=0;
        int zeroscnt=0;
        while(r<n){
            if(nums[r]==0){
                zeroscnt++;
            }
            while(zeroscnt>1){
                if(nums[l]==0){
                    zeroscnt--;
                }
                l++;
            }
           maxlen=Math.max(maxlen,r-l);
           r++;
        }

        return maxlen;
    }
}