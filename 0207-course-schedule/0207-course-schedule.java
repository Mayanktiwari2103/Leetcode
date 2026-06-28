class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       for(int i=0;i<numCourses;i++){
        adj.add(new ArrayList<>());
       }
       for(int[] edge:prerequisites){
        int u=edge[0];
        int v=edge[1];
        adj.get(v).add(u);
       }
       
       int[] indegree=new int[numCourses];
       for(int i=0;i<numCourses;i++){
        for(int it:adj.get(i)){
            indegree[it]++;
        }
       }
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<numCourses;i++){
        if(indegree[i]==0){
            q.add(i);
        }
       }
       int cnt=0;
       while(!q.isEmpty()){
          int node=q.poll();
          cnt++;
          for(int it:adj.get(node)){
            indegree[it]--;
            if(indegree[it]==0){
                q.add(it);
            }
          }
       }

       if(cnt==numCourses){
        return true;
       }
       return false;


        
    }
}