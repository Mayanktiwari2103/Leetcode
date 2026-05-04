class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        ans[n-1]=0;
        for(int i=0;i<n-1;i++){
          for(int j=i+1;j<n;j++){
            if(nums[i]%2==0 && nums[j]%2==1 || nums[i]%2==1 && nums[j]%2==0){
                ans[i]+=1;

            }
           }
            
        }
        return ans;
    }
}