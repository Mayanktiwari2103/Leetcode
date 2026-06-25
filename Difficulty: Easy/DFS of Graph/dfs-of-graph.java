class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ls=new ArrayList<>();
        int n=adj.size();
        int visited[]=new int[n];
        dfs(0,ls,visited,adj);
        return ls;
    }
    
    private void dfs(int node,ArrayList<Integer> ls,int[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[node]=1;
        ls.add(node);
        for(int it:adj.get(node)){
            if(visited[it]==0){
                dfs(it,ls,visited,adj);
            }
        }
    }
}