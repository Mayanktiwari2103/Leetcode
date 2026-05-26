class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        HashSet<Integer> st=new HashSet<>();
        int maxlen=0;
        int n=arr.length;
        for(int val:arr){
            st.add(val);
        }
        for(int val:arr){
            if(!st.contains(val-1)){
                int curr=val;
                int cnt=0;
                while(st.contains(curr)){
                    curr++;
                    cnt++;
                }
                maxlen=Math.max(maxlen,cnt);
            }
        }
        return maxlen;
    }
}