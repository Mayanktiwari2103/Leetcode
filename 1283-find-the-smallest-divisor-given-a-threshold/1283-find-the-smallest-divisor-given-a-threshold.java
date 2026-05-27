class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int l=1;
        int r=Arrays.stream(nums).max().getAsInt();
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(thresh(nums,mid) <= threshold){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }

        }
        return ans;
    }

    private int thresh(int[] nums, int k){
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
           sum+=Math.ceil((double)nums[i]/k);
        }
        return sum;
    }
}