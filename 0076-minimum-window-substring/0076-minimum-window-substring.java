class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[] hash=new int[256];
        int cnt=0;
        int minlen=Integer.MAX_VALUE;
        int sind=-1;
        for(int i=0;i<m;i++){
            hash[t.charAt(i)]++;
        }
        int l=0,r=0;
        while(r<n){
            if(hash[s.charAt(r)]>0) cnt++;
            hash[s.charAt(r)]--;
            while(cnt==m){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    sind=l;

                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) cnt--;
                l++;
            }
            r++;

        }
        return sind==-1?"":s.substring(sind,sind+minlen);

    }
}