class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int l=1;
        int r=Arrays.stream(nums).max().getAsInt();
        while(l<=r){
            int mid=l+(r-l)/2;
            if(getsum(nums,mid)<=threshold){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public int getsum(int[] nums,int k){
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.ceil(nums[i]/(double)k);

        }
        return sum;
    }
}