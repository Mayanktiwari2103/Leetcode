class Solution {
    
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        dist[src]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        
        while(!q.isEmpty()){
            int node=q.poll();
            for(int it:adj.get(node)){
                if(dist[node] +1 < dist[it]){
                    dist[it]=dist[node]+1;
                    q.add(it);
                }
            }
        }
        
        for(int i=0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;
        
    }
    
    
}
