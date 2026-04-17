class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int minimumMultiplications(int[] arr, int start, int end) {
        // code here
        int n=arr.length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(start,0));
        int mod=100000;
        int[] dist=new int[mod];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;
        while(!q.isEmpty()){
            int node=q.peek().first;
            int steps=q.peek().second;
            if(node==end) return steps;
            q.poll();
            for(int i=0;i<n;i++){
                int next=(node*arr[i])%mod;
                if(steps+1 < dist[next]){
                    q.add(new Pair(next,steps+1));
                    dist[next]=steps+1;
                }
                
                
            }
        }
        return -1;
    }
}