class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<ArrayList<Pair>>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:times){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new Pair(v,w));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.first-b.first);
        int[] distance=new int[n+1];
        for(int i=1;i<=n;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        pq.add(new Pair(0,k));
        distance[k]=0;
        while(!pq.isEmpty()){
            int time=pq.peek().first;
            int node=pq.peek().second;
            pq.poll();
            for(Pair it:adj.get(node)){
                int adjnode=it.first;
                int t=it.second;
                if(t+time < distance[adjnode]){
                    pq.add(new Pair(t+time,adjnode));
                    distance[adjnode]=t+time;
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(distance[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans,distance[i]);
        }
        return ans;
        
    }
}