class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            adj.get(edge[0]).add(edge[1]);
        }
        int[] visited=new int[V];
        
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,adj,visited,st);
            }
        }
        
        ArrayList<Integer> ls=new ArrayList<Integer>();
        while(!st.isEmpty()){
            ls.add(st.pop());
    
        }
        return ls;
    }
    
    private void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] visited,Stack<Integer> st){
        visited[node]=1;
        for(int it:adj.get(node)){
            if(visited[it]==0){
                dfs(it,adj,visited,st);
            }
        }
        st.push(node);
    }
}