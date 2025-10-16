class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m=tasks.length;
        int[] freq=new int[26];
        int intervals=0;
        for(int i=0;i<m;i++){
            freq[tasks[i]-'A']++;
        }
        Arrays.sort(freq);
        int maxfreq=freq[25];
        int maxcount=1;
        for(int i=24;i>=0;i--){
            if(freq[i]==maxfreq) maxcount++;
            else break;
        }
        int length=(maxfreq-1)*(n+1)+maxcount;
        return Math.max(m,length);
    }
}