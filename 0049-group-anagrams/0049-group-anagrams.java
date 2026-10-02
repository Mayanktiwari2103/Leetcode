class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        int n=strs.length;
        
        for(int i=0;i<n;i++){
            char[] arr=strs[i].toCharArray();
            Arrays.sort(arr);
            String convert=new String(arr);
            if(!map.containsKey(convert)){
                map.put(convert,new ArrayList<>());
            }
            map.get(convert).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}