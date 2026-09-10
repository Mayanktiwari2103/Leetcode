class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ls=new ArrayList<>();
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] parent=new int[n];
        Arrays.fill(parent,-1);
        int maxlen=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 || nums[j]%nums[i]==0){
                    if(dp[j]+1 > dp[i]){
                        dp[i]=dp[j]+1;
                        parent[i]=j;
                    }
                }
            }
            if(dp[i] > dp[maxlen]){
                maxlen=i;
            }
        }

        int i=maxlen;
        while(parent[i]!=-1){
            ls.add(nums[i]);
            i=parent[i];
        }
        ls.add(nums[i]);
        Collections.reverse(ls);

        return ls;

    }
}