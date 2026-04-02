class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V =isConnected.length;
        ArrayList<ArrayList<Integer>> ls=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            ls.add(new ArrayList<Integer>());
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1 && i!=j){
                    ls.get(i).add(j);
                    ls.get(j).add(i);
                }
            }
        }
        int provinces=0;
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                bfs(isConnected, i , visited);
                provinces++;
            }

        }
        return provinces;
    }

    private void bfs(int[][] isConnected, int start,boolean[] visited){
        int V=isConnected.length;
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int j=0;j<V;j++){
                if(isConnected[node][j]==1 && visited[j]==false){
                    visited[j]=true;
                    q.add(j);
                }
            }
        }
    }
}