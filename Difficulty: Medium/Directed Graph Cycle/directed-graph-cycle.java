class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
        }
        int[] visited=new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(dfsdetect(i,adj,visited)==true){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfsdetect(int start,ArrayList<ArrayList<Integer>> adj,int[] visited ){
        visited[start]=1;
        for(int it:adj.get(start)){
            if(visited[it]==0){
                if(dfsdetect(it,adj,visited)){
                    return true;
                }
            }
            else if(visited[it]==1){
                return true;
            }
        }
        visited[start]=2;
        return false;
    }
}