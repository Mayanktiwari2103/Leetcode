class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] freq=new int[26];
        int l=0;
        int r=0;
        int n=answerKey.length();
        int maxlen=0;
        int maxfreq=0;
        while(r<n){
            freq[answerKey.charAt(r)-'A']++;
            maxfreq=Math.max(maxfreq,freq[answerKey.charAt(r)-'A']);
            int change=(r-l+1)-maxfreq;
            if(change > k){
                freq[answerKey.charAt(l)-'A']--;
                l++;
            }
            if(change<=k) maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}