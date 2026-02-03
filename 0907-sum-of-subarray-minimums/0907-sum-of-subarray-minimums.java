class Solution {
    public int[] nse(int[] arr){
        Stack<Integer> st=new Stack();
        int n=arr.length;
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
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
    public int[] pse(int[] arr){
        Stack<Integer> st=new Stack();
        int n=arr.length;
        int[] ans=new int[n];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() &&  arr[st.peek()]>arr[i]){
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
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int next[]=nse(arr);
        int prev[]=pse(arr);
        long sum=0;
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++){
            int left=i-prev[i];
            int right=next[i]-i;
            sum=(sum+(long)arr[i]*left*right)%mod;


        }
        return (int)sum;
        
    }
}