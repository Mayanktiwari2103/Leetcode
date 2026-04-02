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
                bfs(ls, i , visited);
                provinces++;
            }

        }
        return provinces;
    }

    private void bfs(ArrayList<ArrayList<Integer>> ls, int start,boolean[] visited){
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int it:ls.get(node)){
                if( visited[it]==false){
                    visited[it]=true;
                    q.add(it);
                }
            }
        }
    }
}