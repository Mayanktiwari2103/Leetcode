class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adj=new int[n][n];
        int INF=(int) 1e8;
        for(int[] row:adj){
            Arrays.fill(row,INF);
        }
        for(int i=0;i<n;i++){
            adj[i][i]=0;
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj[u][v]=w;
            adj[v][u]=w;
        }
        
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(adj[i][via]!=INF && adj[via][j]!=INF){
                        adj[i][j]=Math.min(adj[i][j],adj[i][via]+adj[via][j]);
                    }
                }
            }
        }

        int city=-1;
        int mincnt=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(adj[i][j]<=distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<=mincnt){
              mincnt=cnt;
              city=i;
            }
        }
        return city;



    }
}