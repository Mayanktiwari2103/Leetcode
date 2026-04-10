class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
        }
        
        return possible(V,adj);
        
    }
    
    private boolean possible(int V,ArrayList<ArrayList<Integer>> adj){
        
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            int node=q.poll();
            cnt++;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        
        if(cnt==V){
            return false;
        }
        return true;
    }
}