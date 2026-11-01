class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        
        int mini=Arrays.stream(nums).min().getAsInt();
        return sum-n*mini;
    }
}