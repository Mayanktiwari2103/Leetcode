class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        if(k<=1) return 0;
        int l=0;
        int r=0;
        int cnt=0;
        int product=1;
        while(r<n){
            product*=nums[r];
            while(product >= k){
                product/=nums[l];
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }

        return cnt;
    }
}