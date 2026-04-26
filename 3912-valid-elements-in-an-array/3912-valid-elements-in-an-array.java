class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n=nums.length;
        List<Integer> ls=new ArrayList<>();

        int[] prefix=new int[n];
        prefix[0]=nums[0];
        int[] suffix=new int[n];
        suffix[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            if(nums[i]>prefix[i-1]){
                prefix[i]=nums[i];
            }
            else{
                prefix[i]=prefix[i-1];
            }

        }
        for(int i=n-2;i>=0;i--){
            if(nums[i]> suffix[i+1]){
                suffix[i]=nums[i];
            }
            else{
                suffix[i]=suffix[i+1];
            }
        }

        for(int i = 0; i < n; i++){
            if(i == 0 || i == n-1 ||
               nums[i] > prefix[i-1] ||
               nums[i] > suffix[i+1]){
                ls.add(nums[i]);
            }
        }
        return ls;
    }
}