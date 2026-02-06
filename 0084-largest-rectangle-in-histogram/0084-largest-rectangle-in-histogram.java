class Solution {
    public int[] pse(int[] heights){
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
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
    public int[] nse(int[] heights){
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
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
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nexts=nse(heights);
        int[] pres=pse(heights);
        int maxarea=0;
        int area=0;
        for(int i=0;i<n;i++){
            int right=nexts[i]-i;
            int left=i-pres[i];
            int width=(left+right)-1;
            area=heights[i]*width;
            maxarea=Math.max(area,maxarea);
        }
        return maxarea;
    }
}