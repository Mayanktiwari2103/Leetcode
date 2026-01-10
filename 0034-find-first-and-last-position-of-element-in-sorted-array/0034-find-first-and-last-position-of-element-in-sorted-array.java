class Solution {
    public int first(int[] nums,int target){
        int n=nums.length;
        int l=0;
        int r=n-1;
        int first=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                first=mid;
                r=mid-1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return first;

    }
    
    public int last (int[] nums,int target){
        int n=nums.length;
        int l=0;
        int r=n-1;
        int last=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                last=mid;
                l=mid+1;
            }
            else if(nums[mid]< target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return last;
    }
     public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int prev=first(nums,target);
        int next=last(nums,target);
        return new int[] {prev,next};
        

    }
}