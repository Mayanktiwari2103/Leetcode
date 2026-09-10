class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;
        int maxlen=1;
        int len=1;
        for(int i=1;i<n;i++){
            if(nums[i] > nums[i-1]){
                len++;
                maxlen=Math.max(len,maxlen);
            }
            else{
                len=1;
            }
        }
        return maxlen;
    }
}