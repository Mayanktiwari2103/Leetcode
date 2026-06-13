class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        int maxlen=0;
        while(r<n){
            char c=s.charAt(r);
            if(!map.containsKey(c)){
                map.put(c,1);
            }
            else{
                map.put(c,map.get(c)+1);
            }
            while(map.size() >k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        if(map.size() <k) return -1;
        return maxlen;
    }
}