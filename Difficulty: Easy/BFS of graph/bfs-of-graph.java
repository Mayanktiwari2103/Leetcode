class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ls=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int n=adj.size();
        int[] visited=new int[n];
        q.add(0);
        visited[0]=1;
        while(!q.isEmpty()){
            int curr=q.poll();
            ls.add(curr);
            for(int it:adj.get(curr)){
                if(visited[it]==0){
                    q.add(it);
                    visited[it]=1;
                }
            }
        }
        return ls;
    }
}