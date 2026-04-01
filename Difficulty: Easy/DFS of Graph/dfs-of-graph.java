class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V=adj.size();
        ArrayList<Integer> ls=new ArrayList<>();
        boolean[] visited=new boolean[V];
        visited[0]=true;
        dfsgraph(0,adj,ls,visited);
        return ls;
        
        
    }
    private void dfsgraph(int node, ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ls,boolean[] visited){
        visited[node]=true;
        ls.add(node);
        
        for(int it: adj.get(node)){
            if(visited[it]==false){
                dfsgraph(it,adj,ls,visited);
            }
        }
    }
    
}