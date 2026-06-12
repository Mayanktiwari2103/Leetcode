class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int r=0;
        int cnt=0;
        int zeroscnt=0;
        while(r<n){
            if(nums[r]==0){
                zeroscnt++;
            }
            while(zeroscnt > k){
                if(nums[l]==0){
                    zeroscnt--;
                }
                l++;
            }
            cnt=Math.max(cnt,r-l+1);
            r++;

        }
        return cnt;
        
        
    }
}