class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> ls=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
        }
        int[] inc=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                inc[it]++;
            }
        }
        for(int i=0;i<V;i++){
            if(inc[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr=q.poll();
            ls.add(curr);
            for(int it:adj.get(curr)){
                inc[it]--;
                if(inc[it]==0){
                    q.add(it);
                }
            }
        }
        
        return ls;
    }
}