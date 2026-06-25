class Solution {
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        // code here
        ArrayList<ArrayList<Integer>> ls=new ArrayList<>();
        for(int i=0;i<V;i++){
            ls.add(new ArrayList<>());
        }
        for(ArrayList<Integer> edge:edges){
            int u=edge.get(0);
            int v=edge.get(1);
            ls.get(u).add(v);
            ls.get(v).add(u);
        }
        int[] visited=new int[V];
        int cnt=0;
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                bfs(V,ls,visited,i);
                cnt++;
            }
        }
        return cnt;
    }
    
    private void bfs(int V,ArrayList<ArrayList<Integer>> ls,int[] visited,int src){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        visited[src]=1;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int it:ls.get(curr)){
                if(visited[it]==0){
                    q.add(it);
                    visited[it]=1;
                }
            }
        }
    }
}