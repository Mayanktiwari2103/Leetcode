class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int n=intervals.length;
        List<int[]> ls=new ArrayList<>();
        int start=intervals[0][0];
        int lastend=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=lastend){
                lastend=Math.max(lastend,intervals[i][1]);
            }
            else{
                ls.add(new int[]{start,lastend});
                start=intervals[i][0];
                lastend=intervals[i][1];
            }
        }
        ls.add(new int[] {start,lastend});

        return ls.toArray(new int[ls.size()][]) ;
    }
}