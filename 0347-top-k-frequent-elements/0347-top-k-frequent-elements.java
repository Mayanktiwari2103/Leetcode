class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        PriorityQueue<Map.Entry<Integer,Integer>> minheap=new PriorityQueue<>((a,b)-> a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minheap.add(entry);
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        int[] result=new int[k];
        int i=0;
        while(minheap.size()>0){
            result[i]=minheap.poll().getKey();
            i++;
        }
        return result;
    }
}