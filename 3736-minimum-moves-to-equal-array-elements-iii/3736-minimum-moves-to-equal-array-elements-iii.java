class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int maxi=Arrays.stream(nums).max().getAsInt();
        int sum=Arrays.stream(nums).sum();

        return maxi*n-sum;
    }
}