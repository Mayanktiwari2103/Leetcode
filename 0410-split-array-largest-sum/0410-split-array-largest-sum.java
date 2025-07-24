class Solution {
    public int countsubarrays(int[] nums,int maxnumber){
        int subarray=1;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(count+nums[i]<=maxnumber){
                count+=nums[i];
            }
            else{
                subarray++;
                count=nums[i];
            }

        }
        return subarray;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int l=Arrays.stream(nums).max().getAsInt();
        int r=Arrays.stream(nums).sum();
        while(l<=r){
            int mid=(l+r)/2;
            int max=countsubarrays(nums,mid);
            if(max>k){
                l=mid+1;

            }
            else{
                r=mid-1;
            }

        }
        return l;
        
    }
}