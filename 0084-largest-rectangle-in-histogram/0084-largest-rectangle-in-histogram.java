class Solution {
    private int[] pse(int[] heights){
        int n=heights.length;
        Stack<Integer> st=new Stack();
        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                answer[i]=-1;
            }
            else if(heights[st.peek()] < heights[i]){
                answer[i]=st.peek();
            }
            st.push(i);
        }
        return answer;
    }

    private int[] nse(int[] heights){
        int n=heights.length;
        Stack<Integer> st=new Stack();
        int[] answer=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                answer[i]=n;
            }
            else if(heights[st.peek()] < heights[i]){
                answer[i]=st.peek();
            }
            st.push(i);
        }
        return answer;
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] prev=pse(heights);
        int[] next=nse(heights);
        int maxarea=0;
        for(int i=0;i<n;i++){
            int width=next[i]-prev[i]-1;
            maxarea=Math.max(maxarea,heights[i]*width);
        }
        return maxarea;

    }
}