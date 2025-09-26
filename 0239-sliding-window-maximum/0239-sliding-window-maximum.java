class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int idx=0;
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(dq.peekFirst()<=i-k ){
                dq.removeFirst();
            }
            if(i>=k-1){
                ans[idx++]=nums[dq.peekFirst()];
            }

        }
        return ans;
    }
}