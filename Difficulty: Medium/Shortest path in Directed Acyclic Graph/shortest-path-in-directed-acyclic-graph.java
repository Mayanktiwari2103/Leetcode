import java.util.*;

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    private void toposort(int node, ArrayList<ArrayList<Pair>> adj, int vis[], Stack<Integer> st) {
        vis[node] = 1;

        for (Pair it : adj.get(node)) {
            int v = it.first;
            if (vis[v] == 0) {
                toposort(v, adj, vis, st);
            }
        }

        st.push(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new Pair(v, w));
        }

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                toposort(i, adj, vis, st);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);

        dist[0] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();

            if (dist[node] != (int)1e9) {
                for (Pair it : adj.get(node)) {
                    int v = it.first;
                    int w = it.second;

                    if (dist[node] + w < dist[v]) {
                        dist[v] = dist[node] + w;
                    }
                }
            }
        }
        
        for(int i=0;i<V;i++){
            if(dist[i]==(int)1e9){
                dist[i]=-1;
            }
        }

        return dist;
    }
}