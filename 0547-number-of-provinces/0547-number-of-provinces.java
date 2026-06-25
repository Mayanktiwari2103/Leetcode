class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> ls=new ArrayList<>();
        int n=isConnected.length;
        int m=isConnected[0].length;
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1 && i!=j){
                    ls.get(i).add(j);
                }
            }
        }
        int[] visited=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
           if(visited[i]==0){
              cnt++;
              bfs(visited,i,ls);
           }
        }
        return cnt;
    }

    private void bfs(int[] visited,int src,ArrayList<ArrayList<Integer>> ls){
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