class Solution {
    public boolean palindrome(String s,int l,int r){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
        
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        int longest=1;
        int start=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(palindrome(s,i,j)){
                    if((j-i+1)>longest){
                        longest=j-i+1;
                        start=i;
                    }
                }
            }
        }
        return s.substring(start,start+longest);
    }
}