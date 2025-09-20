class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack();
        int[] result=new int[n];
        Arrays.fill(result,-1);
        for(int i=2*n-1;i>=0;i--){
            int index=i % n;
            while(!st.isEmpty() && st.peek()<=nums[index]){
                st.pop();
            }
            if(!st.isEmpty()){
                result[index]=st.peek();
            }
            st.push(nums[index]);

        }
        return result;
    }
}