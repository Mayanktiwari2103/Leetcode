class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }

        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            char c=pq.poll();
            int freq=map.get(c);
            for(int i=0;i<freq;i++){
                sb.append(c);
            }
        }

        return sb.toString();

    }
}