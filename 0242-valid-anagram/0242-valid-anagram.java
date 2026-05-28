class Solution {
    public boolean isAnagram(String s, String t) {
       int n=s.length();
       int m=t.length();
       int[] freq=new int[26];
       if(n!=m) return false;
       for(int i=0;i<n;i++){
        char c=s.charAt(i);
        freq[c-'a']++;
       }

       for(int j=0;j<m;j++){
        char c=t.charAt(j);
        freq[c-'a']--;
       }

       for(int i=0;i<26;i++){
        if(freq[i]>0){
            return false;
        }
       }
       return true;

    }
}