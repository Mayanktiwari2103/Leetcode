// User function Template for Java

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }


    public void unionbysize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    
    private boolean isvalid(int nrow, int ncol, int n , int m){
        return nrow>=0 && nrow<n && ncol>=0 && ncol<m;
    }

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
         int n=rows;
         int m=cols;
        DisjointSet ds=new DisjointSet(n*m);
        List<Integer> ans=new ArrayList<>();
        int[][] vis=new int[n][m];
        int cnt=0;
        for(int[] edge: operators){
            int row=edge[0];
            int col=edge[1];
            if(vis[row][col]==1){
                ans.add(cnt);
                continue;
            }
            vis[row][col]=1;
            cnt++;
            
            int[] drow={-1,0,1,0};
            int[] dcol={0,1,-0,-1};
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(isvalid(nrow,ncol,n,m)){
                    if(vis[nrow][ncol]==1){
                        int nodeno=row*m+col;
                        int adjnode=nrow*m+ncol;
                        if(ds.findUPar(nodeno)!=ds.findUPar(adjnode)){
                            cnt--;
                            ds.unionbysize(nodeno,adjnode);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
        
    }
}