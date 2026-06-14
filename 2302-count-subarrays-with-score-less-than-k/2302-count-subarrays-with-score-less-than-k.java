class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n=nums.length;
        int l=0;
        int r=0;
        long cnt=0;
        long score=0;
        long sum=0;
        while(r<n){
           sum+=nums[r];
           score=sum*(r-l+1);
           while(score >= k){
              sum-=nums[l];
              l++;
              score=sum*(r-l+1);
           }
           cnt+=(r-l+1);
           r++;
        }
        return cnt;
    }
}