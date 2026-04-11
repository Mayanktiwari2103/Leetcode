class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> revadj=new ArrayList<ArrayList<Integer>>();
        int V=graph.length;
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
           revadj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
          for (int j = 0; j < graph[i].length; j++) {
             int neighbor = graph[i][j];
              revadj.get(neighbor).add(i); 
              indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> safe=new ArrayList<Integer>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.peek();
            safe.add(q.poll());
            for(int it:revadj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }

        Collections.sort(safe);
        return safe;

    }
}