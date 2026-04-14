class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.first-b.first);
        ArrayList<ArrayList<Pair>> adj=new ArrayList<ArrayList<Pair>>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        int[] distance=new int[V];
        for(int i=0;i<V;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[src]=0;
        pq.add(new Pair(0,src));
        
        while(!pq.isEmpty()){
            int dist=pq.peek().first;
            int node=pq.peek().second;
            pq.poll();
            for(Pair it:adj.get(node)){
                int v=it.first;
                int w=it.second;
                
                if(dist+w < distance[v]){
                    distance[v]=dist+w;
                    pq.add(new Pair(distance[v],v));
                }
            }
        }
        
        return distance;
    }
}