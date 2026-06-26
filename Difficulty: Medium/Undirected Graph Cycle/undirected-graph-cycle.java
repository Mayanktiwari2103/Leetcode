class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> ls=new ArrayList<>();
        for(int i=0;i<V;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            ls.get(u).add(v);
            ls.get(v).add(u);
        }
        int[] visited=new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(detect(V,ls,i,visited)==true){
                    return true;
                }
            }
        }
        return false;
        
    }
    
    private boolean detect(int V,ArrayList<ArrayList<Integer>> ls,int src,int[] visited){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,-1));
        visited[src]=1;
        while(!q.isEmpty()){
            int node=q.peek().first;
            int parent=q.peek().second;
            q.poll();
            for(int adjnode:ls.get(node)){
                if(visited[adjnode]==0){
                    q.add(new Pair(adjnode,node));
                    visited[adjnode]=1;
                }
                else if(adjnode!=parent){
                    return true;
                }
            }
        }
        return false;
    }
}
