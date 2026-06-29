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
       ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
       for(int i=0;i<=n;i++){
        adj.add(new ArrayList<>());
       } 

       for(int[] time:times){
        int u=time[0];
        int v=time[1];
        int w=time[2];
        adj.get(u).add(new Pair(v,w));
       }
       int[]distance=new int[n+1];
       for(int i=1;i<=n;i++){
        distance[i]=Integer.MAX_VALUE;
       }
       PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.first-b.first);
       pq.add(new Pair(0,k));
       distance[k]=0;
       while(!pq.isEmpty()){
        int first=pq.peek().first;
        int second=pq.peek().second;
        pq.poll();
        for(Pair it:adj.get(second)){
            int u=it.first;
            int v=it.second;
            if(first+v < distance[u]){
                distance[u]=first+v;
                pq.add(new Pair(distance[u],u));
            }
        }
       }
       int max=0;
       for(int i=1;i<=n;i++){
        if(distance[i]==Integer.MAX_VALUE){
            return -1;
        }
        max=Math.max(max,distance[i]);
       }
       return max;
    }
}