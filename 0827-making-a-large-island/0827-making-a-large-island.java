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
    private boolean isvalid(int nrow, int ncol, int n){
        return nrow>=0 && nrow<n && ncol>=0 && ncol<n;
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0) continue;
                int[] drow={-1,0,1,0};
                int[] dcol={0,1,0,-1};
                for(int i=0;i<4;i++){
                    int nrow=row+drow[i];
                    int ncol=col+dcol[i];
                    if(isvalid(nrow,ncol,n) && grid[nrow][ncol]==1){
                        int nodeno=row*n+col;
                        int adjnode=nrow*n+ncol;
                        ds.unionbysize(nodeno,adjnode);
                    }
                }

            }
        }
        
        //step 2
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                int[] drow={-1,0,1,0};
                int[] dcol={0,1,0,-1};
                HashSet<Integer> components=new HashSet<>();
                for(int k=0;k<4;k++){
                    int nrow=i+drow[k];
                    int ncol=j+dcol[k];
                    if(isvalid(nrow,ncol,n) && grid[nrow][ncol]==1){
                          int nodeno=i*n+j;
                          int adjnode=nrow*n+ncol;
                          components.add(ds.findUPar(adjnode));
                    }
                }
                int cnt=0;
                for(Integer parents:components){
                    cnt+=ds.size.get(parents);

                }
                max=Math.max(cnt+1,max);
            }
        }
        for(int i = 0; i < n*n; i++){
            max = Math.max(max, ds.size.get(ds.findUPar(i)));
        }
        return max;
    }
}