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
    public int[] nextgreat(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack();
        int[] nge=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i]=n;
            }
            else{
                nge[i]=st.peek();
            }
            st.push(i);
        }
        return nge;
    }
    public int[] prevgreat(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack();
        int[] pge=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pge[i]=-1;
            }
            else{
                pge[i]=st.peek();
            }
            st.push(i);
        }
        return pge;
    }


    public long subArrayRanges(int[] nums) {
        int[] prevs=prevsmall(nums);
        int[] nexts=nextsmall(nums);
        int[] prevg=prevgreat(nums);
        int[] nextg=nextgreat(nums);
        int n=nums.length;
        long sum=0;
        for(int i=0;i<n;i++){
            int lefts=i-prevs[i];
            int rights=nexts[i]-i;
            int leftg=i-prevg[i];
            int rightg=nextg[i]-i;
            sum=(sum+(long) nums[i]*leftg*rightg);
            sum=(sum-(long) nums[i]*lefts*rights);
        }
        return sum;
    }
}