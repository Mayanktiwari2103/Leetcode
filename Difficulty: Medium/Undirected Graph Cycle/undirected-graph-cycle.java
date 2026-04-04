class Pair{
    int node;
      int parent;
      Pair( int node,int parent){
        this.node=node;
        this.parent=parent;
      }  
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

for (int i = 0; i < V; i++) {
    adj.add(new ArrayList<>());
}

for (int[] edge : edges) {
    int u = edge[0];
    int v = edge[1];

    adj.get(u).add(v);
    adj.get(v).add(u);
}
        int visited[]=new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(detectcycle(i,adj,visited)==true){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean detectcycle(int start, ArrayList<ArrayList<Integer>> adj ,int visited[]){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(start,-1));
        visited[start]=1;
        while(!q.isEmpty()){
            int node=q.peek().node;
            int parent=q.peek().parent;
            q.poll();
            for(int it: adj.get(node)){
                if(visited[it]==0){
                    visited[it]=1;
                    q.add(new Pair(it,node));
                }
                else if(parent!=it){
                    return true;
                }

            }
        }
        return false;
    }
}
