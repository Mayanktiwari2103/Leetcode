class Tuple{
    int row;
    int col;
    int time;
    Tuple(int row, int col, int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Tuple> q=new LinkedList<>();
        int[][] vis=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Tuple(i,j,0));
                    vis[i][j]=1;
                }
            }
        }

        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int second=0;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int time=q.peek().time;
            second=Math.max(second,time);
            q.poll();
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow >=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0 ){
                    q.add(new Tuple(nrow,ncol,time+1));
                    vis[nrow][ncol]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    return -1;
                }
            }
        }
        return second;

    }
}