class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int n=graph.length;
       List<Integer> ls=new ArrayList<>();
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
       }
       int[] outdegree=new int[n];
       for(int i=0;i<n;i++){
        for(int j=0;j<graph[i].length;j++){
            int neighbour=graph[i][j];
            adj.get(neighbour).add(i);
            outdegree[i]++;
        }
       }

       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<n;i++){
        if(outdegree[i]==0){
            q.add(i);
        }
       }

       while(!q.isEmpty()){
        int node=q.poll();
        ls.add(node);
        for(int it:adj.get(node)){
            outdegree[it]--;
            if(outdegree[it]==0){
                q.add(it);
            }
        }
       }   

       Collections.sort(ls);
       return ls;

    }
}