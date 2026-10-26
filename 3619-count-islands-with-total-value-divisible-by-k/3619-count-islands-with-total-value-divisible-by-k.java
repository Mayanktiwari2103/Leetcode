class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    private int bfs(int i , int j, int[][] grid, Queue<Pair> q,int[][] vis,int k,long sum){
        int n=grid.length;
        int m=grid[0].length;
        q.add(new Pair(i,j));
        vis[i][j]=1;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int cnt=0;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            sum+=grid[row][col];
            q.poll();
            for(int t=0;t<4;t++){
                int nrow=row+drow[t];
                int ncol=col+dcol[t];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] >0 && vis[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol));
                    vis[nrow][ncol]=1;
                }
            }
        }
        if(sum%k==0) cnt++;

        return cnt;
    }
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[n][m];
        
        int cnt1=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] >0 && vis[i][j]==0){
                    cnt1+=bfs(i,j,grid,q,vis,k,0);
                }
            }
        }

        return cnt1;
    }
}