// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int length=0;
        int longest=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                length=i-map.get(sum-k);
                longest=Math.max(length,longest);
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return longest;
    }
}
