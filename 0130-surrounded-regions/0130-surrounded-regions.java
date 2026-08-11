class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {    
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                bfs(i,0,q,vis,board);
            }
             if(board[i][m-1]=='O'){
                bfs(i,m-1,q,vis,board);
            }
        }

        for(int j=0;j<m;j++){
            if(board[0][j]=='O'){
                bfs(0,j,q,vis,board);
            }
             if(board[n-1][j]=='O'){
                bfs(n-1,j,q,vis,board);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
        
    }

    private void bfs(int crow, int ccol, Queue<Pair> q, int[][] vis,char[][] board){
         int n=board.length;
        int m=board[0].length;
        q.add(new Pair(crow,ccol));
        vis[crow][ccol]=1;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        
        while(!q.isEmpty()){
           int row=q.peek().row;
           int col=q.peek().col;
           q.poll();
           for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && board[nrow][ncol]=='O' && vis[nrow][ncol]==0){
                q.add(new Pair(nrow,ncol));
                vis[nrow][ncol]=1;
            }
           }
        }
        
    }
}
