class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int n=image.length;
        int m=image[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] visited=new int[n][m];
        q.add(new Pair(sr,sc));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j]=image[i][j];
            }
        }
        int original=image[sr][sc];
        visited[sr][sc]=color;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.poll();
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==original){
                    q.add(new Pair(nrow,ncol));
                    visited[nrow][ncol]=color;
                }
            }
        }
        return visited;
    }
}