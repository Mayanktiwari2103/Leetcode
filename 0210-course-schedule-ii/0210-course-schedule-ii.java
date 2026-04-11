class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        int V=numCourses;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }

        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] topo=new int[V];
        int i=0;
        while(!q.isEmpty()){
            int node=q.peek();
            topo[i++]=q.poll();
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }

        }
        return i==V? topo: new int[]{};
    }
}