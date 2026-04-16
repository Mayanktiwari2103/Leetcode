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
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj =new  ArrayList<ArrayList<Pair>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:flights){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new Pair(v,w));
        }

        Queue<Tuple> q=new LinkedList<>();
        int[] distance=new int[n];
        for(int i=0;i<n;i++){
            distance[i]=Integer.MAX_VALUE;
        }
 
        q.add(new Tuple(0,src,0));
        distance[src]=0;
        while(!q.isEmpty()){
            int stops=q.peek().first;
            int node=q.peek().second;
            int dist=q.peek().third;
            q.poll();
            if(stops > k ) continue;
            for(Pair it:adj.get(node)){
                int adjnode=it.first;
                int weight=it.second;
                if(dist+weight < distance[adjnode] && stops<=k){
                    q.add(new Tuple(stops+1,adjnode,dist+weight));
                    distance[adjnode]=dist+weight;
                }

            }
        }

        if(distance[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return distance[dst];

    }
}