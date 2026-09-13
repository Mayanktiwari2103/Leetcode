class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> ls=new ArrayList<>();
        for(int i=0;i<V;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            ls.get(u).add(v);
            ls.get(v).add(u);
        }
        int[] vis=new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,-1,vis,ls)==true){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int start,int parent, int[] vis,ArrayList<ArrayList<Integer>> ls){
        vis[start]=1;
        for(int it:ls.get(start)){
            if(vis[it]==0){
                vis[it]=1;
                if(dfs(it,start,vis,ls)==true){
                    return true;
                }
            }
            else if(parent!=it){
                return true;
            }
        }
        return false;
    }
}