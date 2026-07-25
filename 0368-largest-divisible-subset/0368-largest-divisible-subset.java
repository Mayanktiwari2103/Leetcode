class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ls=new ArrayList<>();
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int[] parent=new int[n];
        Arrays.fill(parent,-1);
        int maxlen=1;
        int lastind=0;
        Arrays.sort(nums);
        for(int i=1;i<n;i++){
            for(int prev=0; prev < i ; prev++){
                if((nums[i] %  nums[prev]==0 || nums[prev] % nums[i]==0) && dp[prev] + 1 > dp[i]){
                    dp[i]=dp[prev]+1;
                    parent[i]=prev;
                }
            }
            if(dp[i] > maxlen){
                maxlen=dp[i];
                lastind=i;
            }
        }
        int curr=lastind;
        while(curr!=-1){
           ls.add(nums[curr]);
           curr=parent[curr];
        }
        return ls;
    }
}