class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int baskets=2;
        int l=0;
        int r=0;
        int maxlen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(r<n){
            map.put(fruits[r],r);
            while(map.size()>baskets){
                if(map.get(fruits[l])==l){
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