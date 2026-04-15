class Pair{
    int dist;
    int row;
    int col;
    Pair(int dist,int row, int col){
        this.dist=dist;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.dist-b.dist);
        int n=heights.length;
        int m=heights[0].length;
        int[][] distance=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        distance[0][0]=0;
        pq.add(new Pair(0,0,0));
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!pq.isEmpty()){
            int d=pq.peek().dist;
            int r=pq.peek().row;
            int c=pq.peek().col;
            pq.poll();
            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int neweffort=Math.max(d,Math.abs(heights[r][c]-heights[nrow][ncol]));
                    if(neweffort< distance[nrow][ncol]){
                        pq.add(new Pair(neweffort,nrow,ncol));
                        distance[nrow][ncol]=neweffort;
                    }
                }
            }

        }
        return distance[n-1][m-1];
    }
}