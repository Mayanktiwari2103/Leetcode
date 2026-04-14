class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<ArrayList<Pair>>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.first-b.first);
        int[] parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        int[] distance=new int[n+1];
        for(int i=1;i<=n;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[1]=0;
        pq.add(new Pair(0,1));
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
                    parent[v]=node;
                }
            }
        }
        
        
        List<Integer> ls=new ArrayList<>();
        if(distance[n]==Integer.MAX_VALUE){
            ls.add(-1);
            return ls;
        }
        int node=n;
        while(parent[node]!=node){
            ls.add(node);
            node=parent[node];
        }
        ls.add(1);
        ls.add(distance[n]);
        Collections.reverse(ls);
        return ls;
        
    }
}