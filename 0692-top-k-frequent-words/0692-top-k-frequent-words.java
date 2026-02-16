class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n=words.length;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }
            else{
                map.put(words[i],1);
            }
        }
        PriorityQueue<Map.Entry<String,Integer>> minheap=new PriorityQueue<>((a,b)-> {
            int valcompare=a.getValue()-b.getValue();
            if(valcompare!=0) return valcompare;
            return b.getKey().compareTo(a.getKey());
        });
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            minheap.add(entry);
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        ArrayList<String> ls=new ArrayList<>();
        while(!minheap.isEmpty()){
            ls.add(minheap.poll().getKey());
        }
        Collections.reverse(ls);
        return ls;
    }
}