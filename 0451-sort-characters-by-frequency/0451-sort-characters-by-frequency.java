class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
               map.put(c,map.get(c)+1);
            }
            else{
               map.put(c,1);
            }

        } 
        //sort characters by frequency
        List<Character> chars=new ArrayList<>(map.keySet());
        chars.sort((a,b)-> map.get(b)-map.get(a));

        StringBuilder sb=new StringBuilder();
        for(char c: chars){
            int freq=map.get(c);
            for(int i=0;i<freq;i++){
                sb.append(c);
            }
        }
        return sb.toString();
        
          
        
    }
}