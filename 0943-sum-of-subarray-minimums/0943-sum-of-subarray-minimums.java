class Solution {
    public int[] nextsmall(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack();
        int[] nse=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
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
    public int[] prevsmall(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack();
        int[] pse=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
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

    public int sumSubarrayMins(int[] arr) {
        int[] prev=prevsmall(arr);
        int[] next=nextsmall(arr);
        int n=arr.length;
        long sum=0;
        int mod=(int)1e9 +7;
        for(int i=0;i<n;i++){
           int left=i-prev[i];
           int right=next[i]-i;
            sum=(sum+(long) arr[i]*left*right)%mod;
        
        }
        return (int)sum;
    }
}