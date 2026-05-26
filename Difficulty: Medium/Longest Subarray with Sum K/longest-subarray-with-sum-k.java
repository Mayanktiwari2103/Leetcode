// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int maxlen=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                maxlen=Math.max(maxlen,i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            
        }
        return maxlen;
        
    }
}
