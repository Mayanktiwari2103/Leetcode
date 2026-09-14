
class Pair{
    int node;
    int dist;
    Pair(int node, int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
       ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
       ArrayList<Integer> ls=new ArrayList<>();
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
       Arrays.fill(distance,Integer.MAX_VALUE);
       PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.dist-b.dist);
       pq.add(new Pair(src,0));
       distance[src]=0;
       
       while(!pq.isEmpty()){
           int node=pq.peek().node;
           int dist=pq.peek().dist;
           pq.poll();
           if (dist != distance[node]) {
              continue;
           }
           for(Pair it:adj.get(node)){
               int v=it.node;
               int d=it.dist;
               if(distance[node] + d < distance[v]){
                   distance[v]=distance[node]+d;
                   pq.add(new Pair(v,distance[v]));
               }
           }
       }
       
       for(int x:distance){
           ls.add(x);
       }
       
       return ls;
        
    }
}