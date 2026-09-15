class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int l=Arrays.stream(nums).max().getAsInt();
        int r=Arrays.stream(nums).sum();

        while(l<=r){
            int mid=l+(r-l)/2;
            if(cntsubarrays(nums , mid) <=k){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }  

        return l;     
    }

    private int cntsubarrays(int[] nums , int total){
        int n=nums.length;
        int subarray=1;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum>total){
                sum=nums[i];
                subarray++;
            }
        }    

        return subarray;
    }
}