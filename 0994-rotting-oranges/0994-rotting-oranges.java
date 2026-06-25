class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] visited=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                   q.add(new Pair(i,j,0));
                   visited[i][j]=1;
                }
            }
        }
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int time=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;
            time=Math.max(t,time);
            q.poll();
            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol,t+1));
                    visited[nrow][ncol]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1  && visited[i][j]==0){
                    return -1;
                }
            }
        }
        return time;
    }
}