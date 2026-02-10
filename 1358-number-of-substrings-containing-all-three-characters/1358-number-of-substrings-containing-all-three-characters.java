class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int[] cnt=new int[3];
        int l=0;
        int r=0;
        int maxcnt=0;
        while(r<n){
            cnt[s.charAt(r)-'a']++;
            while(cnt[0]>0 && cnt[1]>0 && cnt[2]>0){
                maxcnt+=(n-r);
                cnt[s.charAt(l)-'a']--;
                l++;

            }
            r++;
        }
        return maxcnt;
    }
}