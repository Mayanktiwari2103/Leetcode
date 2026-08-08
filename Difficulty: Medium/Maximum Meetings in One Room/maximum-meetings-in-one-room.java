class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        // code here
        int n=s.length;
        ArrayList<Integer> ls=new ArrayList<>();
        int[][] ans=new int[n][3];
        
        for(int i=0;i<n;i++){
            ans[i][0]=s[i];
            ans[i][1]=f[i];
            ans[i][2]=i+1;
        }
        Arrays.sort(ans, (a,b)-> a[1]-b[1]);
        int start=ans[0][0];
        int lastend=ans[0][1];
        ls.add(ans[0][2]);
        for(int i=1;i<n;i++){
            if(ans[i][0] > lastend){
                start=ans[i][0];
                lastend=ans[i][1];
                ls.add(ans[i][2]);
            }
        }
        Collections.sort(ls);
        return ls;
    }
}