class Solution {
    public int[] nge(int[] temperatures){
        int n=temperatures.length;
        Stack<Integer> st=new Stack();
        int[] answer=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                answer[i]=i;
            }
            else{
                answer[i]=st.peek();
            }
            st.push(i);
        }
        return answer;
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans=nge(temperatures);
        int n=temperatures.length;
        int[] waiting=new int[n];
        for(int i=0;i<n;i++){
            waiting[i]=ans[i]-i;

        }
        return waiting;
    }
}