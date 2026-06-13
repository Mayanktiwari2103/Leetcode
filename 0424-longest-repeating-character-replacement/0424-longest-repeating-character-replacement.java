class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int l=0;
        int r=0;
        int freq[]=new int[26];
        int maxlen=0;
        int maxfreq=0;
        while(r<n){
            freq[s.charAt(r)-'A']++;
            maxfreq=Math.max(maxfreq,freq[s.charAt(r)-'A']);
            int change=(r-l+1)-maxfreq;
            if(change > k){
               freq[s.charAt(l)-'A']--;
               l++;
            }
            if(change <=k) maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}