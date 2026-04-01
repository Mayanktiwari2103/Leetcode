class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V=adj.size();
        ArrayList<Integer> bfs=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[V];
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            bfs.add(node);
            
            for(int it: adj.get(node)){
                if(visited[it]==false){
                    visited[it]=true;
                    q.offer(it);
                }
            }
        }
         return bfs;
    }
 
}