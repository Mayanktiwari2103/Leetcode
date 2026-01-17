class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int cnt1=0;
        int cnt2=0;
        int maxcnt=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='('){
                cnt1++;
            }
            else if(c==')'){
                cnt2++;
            }
            maxcnt=Math.max(maxcnt,cnt1-cnt2);

        }
        return maxcnt;
    }
}