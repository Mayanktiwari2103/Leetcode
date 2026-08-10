class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ls=new ArrayList<>();
        int[] vis=new int[adj.size()];
        dfs(0,adj,ls,vis);
        return ls;
    }
    
    private void dfs(int start,ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> ls, int[] vis){
        ls.add(start);
        vis[start]=1;
        for(int it:adj.get(start)){
            if(vis[it]==0){
                dfs(it,adj,ls,vis);
            }
        }
    }
    
   
}