class Solution {
    public char repeatedCharacter(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int[] freq=new int[26];
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            freq[c-'a']++;
            if(freq[c-'a']==2){
                return c;
            }
        }
        return ' ';
    }
}