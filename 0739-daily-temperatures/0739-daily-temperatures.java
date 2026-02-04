class Solution {
    public int[] nge(int[] temperatures){
        int n=temperatures.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=i;

            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] result=new int[n];
        int nextg[]=nge(temperatures);
        for(int i=0;i<n;i++){
            result[i]=nextg[i]-i;


        }
        return result;

    }
}