class Solution {    
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] visited=new int[n][m];
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};       
        for(int j=0;j<m;j++){
           if(board[0][j]=='O' && visited[0][j]==0 ){
            dfs(0,j,board,visited,drow,dcol);
           }
           if(board[n-1][j]=='O' && visited[n-1][j]==0 ){
            dfs(n-1,j,board,visited,drow,dcol);
           }
        }

        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && visited[i][0]==0){
                dfs(i,0,board,visited,drow,dcol);
            }
            if(board[i][m-1]=='O' && visited[i][m-1]==0){
                dfs(i,m-1,board,visited,drow,dcol);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs(int row, int col,char[][] board,int[][] visited,int[] drow, int[] dcol){
        visited[row][col]=1;
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>0 && nrow<n && ncol>0 && ncol<m && visited[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(nrow,ncol,board,visited,drow,dcol);
            }
        }
    }
}