class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int l=0;
        int r=0;
        int maxlen=0;
        int maxfreq=0;
        int freq[]=new int[26];
        while(r<n){
            freq[s.charAt(r)-'A']++;
            maxfreq=Math.max(maxfreq,freq[s.charAt(r)-'A']);
            int changes=(r-l+1)-maxfreq;
            if(changes>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            if(changes<=k){
                maxlen=Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}