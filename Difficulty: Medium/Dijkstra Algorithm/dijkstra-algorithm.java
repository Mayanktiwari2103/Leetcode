class Pair{
    int node;
    int distance;
    Pair(int node,int distance){
        this.node=node;
        this.distance=distance;
    }
} 
class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int d=edge[2];
            adj.get(u).add(new Pair(v,d));
            adj.get(v).add(new Pair(u,d));
        }
        ArrayList<Integer> ls= new ArrayList<>();
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.distance-b.distance);
        pq.add(new Pair(src,0));
        
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.node;
            int distance=curr.distance;
            
            if(distance > dist[node]) continue;
            
            for(Pair it:adj.get(node)){
                int u=it.node;
                int v=it.distance;
                if(distance+ v < dist[u]){
                    dist[u]=distance+v;
                    pq.add(new Pair(u,dist[u]));
                }
            }
            
        }
        
        for(int x:dist){
            ls.add(x);
        }
        return ls;
        
    }
}