class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return lessthanequaltok(nums,k)-lessthanequaltok(nums,k-1);
    }
    private int lessthanequaltok(int[] nums,int k){
        if(k<0) return 0;
        int n=nums.length;
        int l=0,r=0;
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
            cnt=cnt+(r-l+1);     
            r++;
        }
        return cnt;
    }
}