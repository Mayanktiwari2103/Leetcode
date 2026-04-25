class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] prefixmax=new int[n];
        int[] suffixmin=new int[n];
        prefixmax[0]=nums[0];
        suffixmin[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            if(nums[i]>prefixmax[i-1]){
                prefixmax[i]=nums[i];
            }
            else{
                prefixmax[i]=prefixmax[i-1];
            }
        }

        for(int i=n-2;i>=0;i--){
            if(nums[i] < suffixmin[i+1]){
                suffixmin[i]=nums[i];
            }
            else{
                suffixmin[i]=suffixmin[i+1];
            }
        }
        //int minind=
        for(int i=0;i<n;i++){
            if(prefixmax[i]-suffixmin[i]<=k){
                return i;
            }
        }
        return -1;
    }
}