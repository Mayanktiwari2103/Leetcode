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
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        ArrayList<Integer> ls= new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            ls.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        
        return ls;
        
    }
    
    
}