class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int maxlen=0;
        int l=0;
        int r=0;
        while(r<n){
            if(map.containsKey(s.charAt(r)) && l<=map.get(s.charAt(r))){
                l=map.get(s.charAt(r))+1;
            }
            map.put(s.charAt(r),r);
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }

        return maxlen;
    }
}