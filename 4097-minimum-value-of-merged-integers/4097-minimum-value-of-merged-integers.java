class Solution {
    public int minMergedInteger(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n/2];

        int j=0;
        for(int i=0;i<n-1;i+=2){
          ans[j++]=nums[i]*(int) Math.pow(10,Integer.toString(nums[i+1]).length()) + nums[i+1];
        }
        
        int mini=ans[0];
        for(int k=1;k<ans.length;k++){
            if(ans[k] < mini){
                mini=ans[k];
            }
        }

        return mini;
    }
}