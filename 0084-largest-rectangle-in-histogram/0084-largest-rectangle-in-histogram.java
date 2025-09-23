class Solution { 
    private int[] nse(int[] heights){
        int n=heights.length;
        Stack<Integer> st=new Stack();
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
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
    private int[] pse(int[] heights){
        int n=heights.length;
        Stack<Integer> st=new Stack();
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
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
    public int largestRectangleArea(int[] heights) {
        int[] next=nse(heights);
        int[] pre=pse(heights);
        int n=heights.length;
        int maxarea=0;
        for(int i=0;i<n;i++){
            int width=next[i]-pre[i]-1;
            int area=heights[i]*width;
            maxarea=Math.max(maxarea,area);
        }
        return maxarea;

    }
}