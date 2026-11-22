class Solution {
    public boolean checkString(String s) {
        int n=s.length();
        int[] freq=new int[2];
        int store=-1;
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
            if(s.charAt(i)=='a'){
               store=i;
            }
            if(freq[1]!=0 && store==i){
                return false;
            }
        }

        return true;
    }
}