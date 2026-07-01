class Disjoint{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    Disjoint(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findUpar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp=findUpar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    
    public void unionbysize(int u, int v){
        int ulp_u=findUpar(u);
        int ulp_v=findUpar(v);
        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        Arrays.sort(edges,(a,b)-> a[2]-b[2]);
        Disjoint ds=new Disjoint(V);
        int sum=0;
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            if(ds.findUpar(u)!=ds.findUpar(v)){
                ds.unionbysize(u,v);
                sum+=w;
            }
        }
        return sum;
    }
}
