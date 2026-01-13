class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int l=Arrays.stream(nums).max().getAsInt();
        int r=Arrays.stream(nums).sum();
        while(l<=r){
            int mid=l+(r-l)/2;
            if(subarray(nums,mid)<=k){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public int subarray(int[] nums,int a){
        int n=nums.length;
        int sum=0;
        int cnt=1;
        for(int i=0;i<n;i++){
            if(sum+nums[i]>a){
                cnt++;
                sum=nums[i];
            }
            else{
                sum+=nums[i];
            }
        }
        return cnt;
    }
}