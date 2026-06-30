class Tuple{
    int first;
    int second;
    int third;
    Tuple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] distance=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)-> a.third-b.third);
        pq.add(new Tuple(0,0,grid[0][0]));
        distance[0][0]=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!pq.isEmpty()){
            int row=pq.peek().first;
            int col=pq.peek().second;
            int dist=pq.peek().third;
            pq.poll();
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m ){
                    int newtime=Math.max(dist,grid[nrow][ncol]);
                    if(newtime < distance[nrow][ncol]){
                         pq.add(new Tuple(nrow,ncol,newtime));
                         distance[nrow][ncol]=newtime;
                    }
                }

            }
            
        }
        return distance[n-1][m-1];
    }
}