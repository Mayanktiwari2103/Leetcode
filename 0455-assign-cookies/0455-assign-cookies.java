class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0;
        int cnt=0;
        int i=0;
        while(i<n && j<m){
            if(s[j]>=g[i]){
                cnt++;
                i++;
            }
            j++;

        }
        return cnt;
    }
}