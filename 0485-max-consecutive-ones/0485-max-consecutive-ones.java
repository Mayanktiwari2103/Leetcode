class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int cnt=0;
        int maxcnt=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                cnt++;
                maxcnt=Math.max(maxcnt,cnt);
            }
            else{
                cnt=0;
            }
        }
        return maxcnt;
        
    }
}