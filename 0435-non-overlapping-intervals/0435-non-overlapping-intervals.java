class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int cnt=0;
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)-> a[1]-b[1]);
        int start=intervals[0][0];
        int lastend=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0] < lastend){
                cnt++;
            }
            else{
                lastend=intervals[i][1];
            }
        }
        return cnt;
    }
}