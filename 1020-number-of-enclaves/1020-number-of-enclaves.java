class Solution {

    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int cntfirst=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                   cntfirst++;
                }
            }
        }

        for(int j=0;j<m;j++){
            if(grid[0][j]==1 && visited[0][j]==0){
                dfs(0,j,grid,visited,drow,dcol);
            }
            if(grid[n-1][j]==1 && visited[n-1][j]==0){
                dfs(n-1,j,grid,visited,drow,dcol);
            }

        }

        for(int i=0;i<n;i++){
            if(grid[i][0]==1 && visited[i][0]==0){
                dfs(i,0,grid,visited,drow,dcol);
            }
            if(grid[i][m-1]==1 && visited[i][m-1]==0){
                dfs(i,m-1,grid,visited,drow,dcol);
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==1 && grid[i][j]==1){
                    cnt++;
                }
            }
        }

        return cntfirst-cnt;

    }
    private void dfs(int row, int col,int[][] grid, int[][] visited,int[] drow, int[] dcol){
        int n=grid.length;
        int m=grid[0].length;
        visited[row][col]=1;
        for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,grid,visited,drow,dcol);
            }
        }
    }
}