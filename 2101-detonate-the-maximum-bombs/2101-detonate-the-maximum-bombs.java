class Solution {
    private int bfs(int[][] bombs ,int start,ArrayList<ArrayList<Integer>> adj, int cnt, Queue<Integer> q){
        int n=bombs.length;
        int[] vis=new int[n];
        q.add(start);
        vis[start]=1;
        while(!q.isEmpty()){
            int node=q.peek();
            q.poll();
            cnt++;
            for(int it:adj.get(node)){
                if(vis[it]==0){
                    vis[it]=1;
                    q.add(it);
                }
            }
        }

        return cnt;

    }
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;
        int m=bombs[0].length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int x=bombs[i][0];
            int y=bombs[i][1];
            int r=bombs[i][2];

            for(int j=0;j<n;j++){
                if(i==j) continue;

                int x1=bombs[j][0];
                int y1=bombs[j][1];

                long dx=x1-x;
                long dy=y1-y;

                if(dx*dx + dy*dy <=(long) r*r){
                    adj.get(i).add(j);
                }                
            }
        }
        int ans=0;
        int cnt=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            cnt=bfs(bombs,i,adj,0,q);
            ans=Math.max(ans,cnt);
        }
        return ans;

    }
}