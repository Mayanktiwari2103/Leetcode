class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int l=Arrays.stream(nums).max().getAsInt();
        int r=Arrays.stream(nums).sum();
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(subarrays(nums,mid) <= k){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;

            }
        }
        return ans;
    }

    private int subarrays(int[] nums, int sum){
        int n=nums.length;
        int cntsubarray=1;
        int total=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
            if(total > sum){
                cntsubarray++;
                total=nums[i];
            }

        }
        return cntsubarray;
    }
}