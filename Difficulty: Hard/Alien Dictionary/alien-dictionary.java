class Solution {
    
    private List<Integer> toposort(ArrayList<ArrayList<Integer>> adj,int V){
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
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            topo.add(q.poll());
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return topo;
    }
    public String findOrder(String[] words) {
        // code here
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;

        for(String word : words){
            for(char ch : word.toCharArray()){
                if(!map.containsKey(ch)){
                    map.put(ch, idx++);
                }
            }
        }

        int k = map.size();

        // reverse map
        char[] rev = new char[k];
        for(Map.Entry<Character, Integer> e : map.entrySet()){
            rev[e.getValue()] = e.getKey();
        }
       ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
       int n=words.length;
       for(int i=0;i<k;i++){
           adj.add(new ArrayList<>());
       }
       
       for(int i=0;i<n-1;i++){
           String s1=words[i];
           String s2=words[i+1];
           if(s1.length() > s2.length() && s1.startsWith(s2)){
                return "";
            }
           int len=Math.min(s1.length(),s2.length());
           for(int j=0;j<len;j++){
               if(s1.charAt(j)!=s2.charAt(j)){
                  adj.get(map.get(s1.charAt(j)))
                       .add(map.get(s2.charAt(j)));
                   break;
               }
           }
       }
       
       List<Integer> topo=toposort(adj,k);
       if(topo.size()<k) return "";
       String ans="";
       for(int it:topo){
           ans+=rev[it];
       }
       return ans;
    }
}