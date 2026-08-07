class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n=arr.length;
        ArrayList<Integer> ls=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ls.add(st.peek());
            }
            if(st.isEmpty()){
                ls.add(-1);
            }
            st.push(arr[i]);
        }
        Collections.reverse(ls);
        return ls;
    }
}