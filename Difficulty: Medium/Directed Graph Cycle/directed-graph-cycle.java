class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> ls=new ArrayList<>();
        for(int i=0;i<V;i++){
            ls.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            ls.get(u).add(v);
        }
        int[] vis=new int[V];
        int[] pathvis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(ls,vis,pathvis,i)==true){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(ArrayList<ArrayList<Integer>> ls,int[] vis, int[] pathvis,int src){
        vis[src]=1;
        pathvis[src]=1;
        for(int it:ls.get(src)){
            if(vis[it]==0){
                if(dfs(ls,vis,pathvis,it)==true){
                    return true;
                }
            }
            else if(pathvis[it]==1){
                return true;
            }
        }
        pathvis[src]=0;
        return false;
    }
}