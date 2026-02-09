class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    public int atmost(int[] nums, int k){
        int n=nums.length;
        if(k<0) return 0;
        int l=0;
        int r=0;
        int cnt=0;
        int odd=0;
        while(r<n){
            if(nums[r]%2==1){
                odd++;
            }
            while(odd>k){
                if(nums[l]%2==1){
                    odd--;
                }
                l++;
            }
            cnt+=(r-l+1);
            r++;

        }
        return cnt;
    }
}