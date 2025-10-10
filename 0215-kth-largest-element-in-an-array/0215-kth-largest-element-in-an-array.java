class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            minheap.add(nums[i]);
            if(minheap.size()>k){
                minheap.poll();      
            }
        }
        return minheap.peek();
    }
}