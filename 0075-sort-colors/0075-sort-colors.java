class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int cnt1=0;
        int cnt2=0;
        int cnt3=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                cnt1++;
            }
            else if(nums[i]==1){
                cnt2++;
            }
            else{
                cnt3++;
            }
        }
        for(int i=0;i<n;i++){
            if(cnt1>0){
                nums[i]=0;
                cnt1--;
            }
            else if(cnt2>0){
                nums[i]=1;
                cnt2--;
            }
            else{
                nums[i]=2;
                cnt3--;
            }

        }
    }
}