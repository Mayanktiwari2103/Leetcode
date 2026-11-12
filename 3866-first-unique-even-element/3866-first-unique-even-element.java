class Solution {
    public int firstUniqueEven(int[] nums) {
        int n=nums.length;
        int[] freq=new int[101];

        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }

        for(int i=0;i<n;i++){
            if(freq[nums[i]]==1 && nums[i]%2==0){
                return nums[i];
            }
        }

        return -1;
    }
}