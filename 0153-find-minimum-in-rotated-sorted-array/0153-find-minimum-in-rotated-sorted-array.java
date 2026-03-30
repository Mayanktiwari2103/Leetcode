class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        int min=Integer.MAX_VALUE;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[l]<=nums[mid]){
                if(nums[l]<min){
                    min=nums[l];
                }
                l=mid+1;
            }
            if(nums[mid]<=nums[r]){
                if(nums[mid]<min){
                    min=nums[mid];
                }
                r=mid-1;
            }
        }
        return min;
    }
}