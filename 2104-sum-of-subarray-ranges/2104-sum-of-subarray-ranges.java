class Solution {
    public int[] nse(int[] nums){
        int n =nums.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=n;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public int[] pse(int[] nums){
        int n =nums.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public int[] nge(int[] nums){
        int n =nums.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=n;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public int[] pge(int[] nums){
        int n =nums.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        int prevs[]=pse(nums);
        int nexts[]=nse(nums);
        int prevg[]=pge(nums);
        int nextg[]=nge(nums);
        long sum=0;
        for(int i=0;i<n;i++){
            int left1=i-prevs[i];
            int right1=nexts[i]-i;
            int left2=i-prevg[i];
            int right2=nextg[i]-i;
            long min=left1*right1;
            long max=left2*right2;
            sum+=(long)(nums[i]*max-nums[i]*min);
        }
        return sum;
        
    }
}