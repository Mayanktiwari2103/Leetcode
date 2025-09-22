class Solution {
    public int[] prevsmall(int[] heights){
        int n=heights.length;
        Stack<Integer> st=new Stack();
        int[] pse=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }
            else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        return pse;
    }
    public int[] nextsmall(int[] heights){
        int n=heights.length;
        Stack<Integer> st=new Stack();
        int[] nse=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=n;
            }
            else{
                nse[i]=st.peek();
            }
            st.push(i);
        }
        return nse;
    }

    public int largestRectangleArea(int[] heights) {
        int[] prev=prevsmall(heights);
        int[] next=nextsmall(heights);
        int maxarea=0;
        int n=heights.length;
        for(int i=0;i<n;i++){
          int width=next[i]-prev[i]-1;
          int area=heights[i]*width;
          maxarea=Math.max(maxarea,area);

        }
        return maxarea;

    }
}