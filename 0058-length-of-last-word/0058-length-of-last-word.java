class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length();
        int cnt=0;
        for(int i=n-1;i>=0;i--){
            char c=s.charAt(i);
            if(c!=' ' && (c>='a' && c<='z' || c>='A' && c<='Z')){
                cnt++;
            }
            else if(cnt>0){
                break;
            }

        }
        return cnt;
    }
}