class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int l=0,r=0,maxlen=0;
        int cnt=0;
        while(r<n){
            if(nums[r]==0){
                cnt++;
            }
            if(cnt>k){
                if(nums[l]==0){
                    cnt--;
                }
                l++;
            }
            if(cnt<=k){
                maxlen=Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
        
    }
}