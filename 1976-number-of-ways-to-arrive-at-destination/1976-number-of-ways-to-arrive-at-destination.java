class Pair{
    int first;
    long second;
    Pair(int first,long second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<ArrayList<Pair>>();
        int MOD = (int)(1e9 + 7);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:roads){
            int u=edge[0];
            int v=edge[1];
            int t=edge[2];
            adj.get(u).add(new Pair(v,t));
            adj.get(v).add(new Pair(u,t));
        }

        long[] distance=new long[n];
        Arrays.fill(distance,Long.MAX_VALUE);
        int[] ways=new int[n];
        ways[0]=1;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.second,b.second) );
        pq.add(new Pair(0,0));
        distance[0]=0;
        while(!pq.isEmpty()){
            int node=pq.peek().first;
            long dist=pq.peek().second;
            pq.poll();
            for(Pair it:adj.get(node)){
                int adjnode=it.first;
                long t=it.second;
                if(dist+t < distance[adjnode]){
                    distance[adjnode]=dist+t;
                    pq.add(new Pair(adjnode,distance[adjnode]));
                    ways[adjnode]=ways[node];
                }
                else if(dist+t == distance[adjnode] ){
                    ways[adjnode]=(ways[adjnode]+ways[node])%MOD;
                }
            }
        }
        return ways[n-1];
    }
}