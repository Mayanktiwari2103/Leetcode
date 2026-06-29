class Pair{
    int row;
    int col;
    int dist;
    Pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        if(grid[0][0]==1) return -1;
        q.add(new Pair(0,0,0));
        int[][] distance=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        distance[0][0]=0;
        
        int[] drow={-1,-1,0,1,1,1,0,-1};
        int[] dcol={0,1,1,1,0,-1,-1,-1};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int dist=q.peek().dist;
            q.poll();
            for(int i=0;i<8;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0 && dist+1 < distance[nrow][ncol]){
                    q.add(new Pair(nrow,ncol,dist+1));
                    distance[nrow][ncol]=dist+1;

                }
            }
        }
        if(distance[n-1][m-1]==Integer.MAX_VALUE) return -1; 
        return distance[n-1][m-1]+1;
    }
}