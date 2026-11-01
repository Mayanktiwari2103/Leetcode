class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int median=(n%2==1)?nums[n/2]:(nums[n/2]+nums[(n/2)-1])/2;
        
        int moves=0;
        for(int x:nums){
          moves+=Math.abs(x-median);
        }
        return moves;
        
    }
}