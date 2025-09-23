class Solution {
    public int[] pse(int[] heights){
        Stack<Integer> st=new Stack();
        int n=heights.length;
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
        Stack<Integer> st=new Stack();
        int n=heights.length;
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
    public int largestarea(int[] heights){
        int[] next=nse(heights);
        int[] pre=pse(heights);
        int n=heights.length;
        int maxarea=0;
        for(int i=0;i<n;i++){
            int width=next[i]-pre[i]-1;
            int area=heights[i]*width;
            maxarea=Math.max(area,maxarea);
        }
        return maxarea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int maxarea=0;
        int[] heights=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    heights[j]+=1;
                }
                else{
                    heights[j]=0;
                }

            }
            maxarea=Math.max(maxarea,largestarea(heights));
        }
        return maxarea;

    }
}