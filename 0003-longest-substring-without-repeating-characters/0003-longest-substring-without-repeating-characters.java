class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int l=0,r=0;
        int maxlen=0;
        while(r<n){
            char c=s.charAt(r);
            if(map.containsKey(s.charAt(r))){
                if(map.get(c)>=l){// it should be in current window
                    l=map.get(c)+1;
                }
            }
            map.put(c,r);//character and it's index
            maxlen=Math.max(maxlen,r-l+1);
            r++;

        }
        return maxlen;
    }    
           
}