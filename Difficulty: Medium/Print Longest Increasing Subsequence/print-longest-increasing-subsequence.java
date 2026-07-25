class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] parent=new int[n];
        Arrays.fill(parent,-1);
        int maxlen=1;
        int lastind=0;
        for(int i=0;i<n;i++){
            for(int prev=0;prev < i ; prev++){
                if(arr[prev] < arr[i] && dp[prev] + 1 > dp[i]){
                    dp[i]=dp[prev]+1;
                    parent[i]=prev;
                }
            }
            
            if(dp[i] > maxlen){
                maxlen=dp[i];
                lastind=i;
            }
        }
        
        ArrayList<Integer> ls=new ArrayList<>();
        int curr=lastind;
        while(curr!=-1){
            ls.add(arr[curr]);
            curr=parent[curr];
        }
        
        Collections.reverse(ls);
        return ls;
    }
}
