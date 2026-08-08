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

       PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());
       for(Map.Entry<Integer,Integer> entry : map.entrySet()){
           pq.add(entry);
           if(pq.size() > k){
            pq.poll();
           }
        }

        int[] ans=new int[k];
        int ind=0;
        while(!pq.isEmpty()){
            ans[ind++]=pq.poll().getKey();
        }
        return ans;
        
    }
}