class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    private int bfs(int i,int j, int[][] grid,int[][] vis,Queue<Pair> q){
        int n=grid.length;
        int m=grid[0].length;
        q.add(new Pair(i,j));
        vis[i][j]=1;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        boolean isClosed=true;
        int cnt=0;

        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            q.poll();
            for(int k=0;k<4;k++){
                int nrow=r+drow[k];
                int ncol=c+dcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==0){
                   if(nrow==0 || nrow==n-1 || ncol==0 || ncol==m-1){
                    isClosed=false;
                   }
                   q.add(new Pair(nrow,ncol));
                   vis[nrow][ncol]=1;
                }
            }

        }
        if(isClosed==true){
            cnt++;
        }
         return cnt;
    }
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        int cnt1=0;

        for(int i=1;i<n-1;i++){
          for(int j=1;j<m-1;j++){
            if(grid[i][j]==0 && vis[i][j]==0){
               cnt1+= bfs(i,j,grid,vis,q);
            }
          }
        }

        return cnt1;
        

        
    }
}