class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
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
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.first-b.first);
        int[] vis=new int[V];
        pq.add(new Pair(0,0));
        int sum=0;
        while(!pq.isEmpty()){
            int wt=pq.peek().first;
            int node=pq.peek().second;
            pq.poll();
            
            if(vis[node]==1) continue;
            vis[node]=1;
            sum+=wt;
            for(Pair it:adj.get(node)){
                int adjnode=it.first;
                int w=it.second;
                if(vis[adjnode]==0){
                    pq.add(new Pair(w,adjnode));
                }
            }
        }
        return sum;
        
    }
}
