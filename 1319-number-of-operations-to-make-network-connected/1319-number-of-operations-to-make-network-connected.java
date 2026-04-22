class DisjointSet{
    List<Integer> size=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            size.add(1);
            parent.add(i);
       }

    }
   
    public int findUPar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp=findUPar(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }

    public void unionbysize(int u, int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }
    }
    
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        if(connections.length < n-1) return -1;
        for(int[] edge:connections){
            int u=edge[0];
            int v=edge[1];
            if(ds.findUPar(u)!=ds.findUPar(v)){
                ds.unionbysize(u,v);
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(ds.findUPar(i)==i){
                cnt++;
            }

        }
        return cnt-1;
    }
}