class Pair{
    int node;
    int dist;
    Pair(int node, int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] distance=new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,0));
        distance[src]=0;
        while(!q.isEmpty()){
            int node=q.peek().node;
            int dist=q.peek().dist;
            q.poll();
            for(int it:adj.get(node)){
                if(dist+1 < distance[it]){
                    distance[it]=dist+1;
                    q.add(new Pair(it,distance[it]));
                }
            }
        }
        for(int i=0;i<V;i++){
            if(distance[i]==Integer.MAX_VALUE){
                distance[i]=-1;
            }
        }
        return distance;
    }
    
    
}
