class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                vis[i][j]=image[i][j];
            }
        }
        q.add(new Pair(sr,sc));
        vis[sr][sc]=color;
        
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!q.isEmpty()){
           int row=q.peek().row;
           int col=q.peek().col;
           q.poll();
           for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==image[row][col] && vis[nrow][ncol]!=vis[row][col]){
                q.add(new Pair(nrow,ncol));
                vis[nrow][ncol]=vis[row][col];
            }
           }
        }

        return vis;
    }
}