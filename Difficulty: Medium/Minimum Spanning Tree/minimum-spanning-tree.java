class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Tuple{
    int first;
    int second;
    int third;
    Tuple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
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
        
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)-> a.first-b.first);
        int[] vis=new int[V];
        List<Pair> ls=new ArrayList<>();
        pq.add(new Tuple(0,0,-1));
        int sum=0;
        while(!pq.isEmpty()){
            int dist=pq.peek().first;
            int node=pq.peek().second;
            int parent=pq.peek().third;
            pq.poll();
            if(vis[node]==1) continue;
            vis[node]=1;
            sum+=dist;
            if(parent!=-1){
                ls.add(new Pair(parent,node));
            }
            for(Pair it:adj.get(node)){
                int v=it.first;
                int w=it.second;
                if(vis[v]==0){
                    pq.add(new Tuple(w,v,node));
                }
            }
        }
        
        return sum;
        
    }
}
