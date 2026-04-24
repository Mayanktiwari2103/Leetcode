class DisjointSet{
    List<Integer> size=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        if(node==parent.get(node)){
            return node;
        }

        int ulp=findUPar(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }

    public void unionbysize(int u, int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v) return;
        else if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    private  boolean isvalid(int nrow, int ncol , int n , int m){
        return nrow>=0 && nrow<m && ncol>=0 && ncol<n;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        DisjointSet ds=new DisjointSet(m*n);
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0) continue;
                int[] drow={-1,0,1,0};
                int[] dcol={0,1,0,-1};
                for(int i=0;i<4;i++){
                    int nrow=row+drow[i];
                    int ncol=col+dcol[i];
                    if(isvalid(nrow,ncol,n,m) && grid[nrow][ncol]==1){
                        int nodeno=row*n+col;
                        int adjnode=nrow*n+ncol;
                        ds.unionbysize(nodeno,adjnode);
                    }
                }
            }
        }

        int maxcnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int node=i*n+j;
                    maxcnt=Math.max(maxcnt,ds.size.get(ds.findUPar(node)));
                }
            }
        }
        return maxcnt;
    }
}