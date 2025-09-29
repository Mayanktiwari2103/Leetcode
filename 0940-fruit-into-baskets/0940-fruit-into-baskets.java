class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=fruits.length;
        int l=0,r=0;
        int maxlen=0;
        int basket=2;
        while(r<n){
            map.put(fruits[r],r);
            if(map.size()>basket){
                if (map.get(fruits[l]) == l) {
                     map.remove(fruits[l]);   
                }
                l++;
            
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}