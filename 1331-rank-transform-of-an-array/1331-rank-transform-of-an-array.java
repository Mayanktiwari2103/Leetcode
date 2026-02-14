class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int[] sorted=arr.clone();
        Arrays.sort(sorted);
        int result[]=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        int rank=1;
        for(int i=0;i<n;i++){
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i],rank++);
            }
        }
        for(int i=0;i<n;i++){
            result[i]=map.get(arr[i]);
        }
        return result;
    }
}