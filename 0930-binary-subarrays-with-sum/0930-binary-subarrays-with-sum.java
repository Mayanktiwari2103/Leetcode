class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return num(nums,goal)-num(nums,goal-1);
    }
    public int num(int[] nums, int goal){
        int n=nums.length;
        if(goal<0) return 0;
        int l=0;
        int r=0;
        int cnt=0;
        int sum=0;
        while(r<n){
            sum+=nums[r];
            while(sum>goal){
                sum=sum-nums[l];
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
}