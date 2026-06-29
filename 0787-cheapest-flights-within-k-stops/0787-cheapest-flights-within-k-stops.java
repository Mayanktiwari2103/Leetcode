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
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int flight[]:flights){
            int u=flight[0];
            int v=flight[1];
            int w=flight[2];
            adj.get(u).add(new Pair(v,w));
        }
        int[] distance=new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        //PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)-> a.first-b.first);
        Queue<Tuple> pq=new LinkedList<>();
        pq.add(new Tuple(0,src,0));
        distance[src]=0;
        while(!pq.isEmpty()){
            int dist=pq.peek().first;
            int node=pq.peek().second;
            int stops=pq.peek().third;
            pq.poll();
            if(stops> k) continue;
            for(Pair it:adj.get(node)){
                int u=it.first;
                int v=it.second;
                if(dist+v < distance[u]){
                    distance[u]=dist+v;
                    pq.add(new Tuple(distance[u],u,stops+1));
                }
            }

        }
        if(distance[dst]==Integer.MAX_VALUE) return -1;
        return distance[dst];

    }
}