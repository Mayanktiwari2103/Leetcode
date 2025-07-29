class Solution {
    public int division(int[] nums,int smallest){
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.ceil((double)nums[i]/(double)smallest);

        }
        return sum;

    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int low=1;
        int high=Arrays.stream(nums).max().getAsInt();
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            int find=division(nums,mid);
            if(find<=threshold){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return ans;

        
    }
}