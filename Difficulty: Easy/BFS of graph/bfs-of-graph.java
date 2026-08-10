class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
       ArrayList<Integer> ls=new ArrayList<>();
       Queue<Integer> q=new LinkedList<>();
       int[] vis=new int[adj.size()];
       q.add(0);
       vis[0]=1;
       while(!q.isEmpty()){
           int node=q.poll();
           ls.add(node);
           for(int it:adj.get(node)){
               if(vis[it]==0){
                   q.add(it);
                   vis[it]=1;
               }
           }
       }
       return ls;
    }
}