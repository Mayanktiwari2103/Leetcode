class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        int posind=0;
        int negind=1;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result[posind]=nums[i];
                posind+=2;
            }
            else{
                result[negind]=nums[i];
                negind+=2;
            }
        }
        return result;
    }
}