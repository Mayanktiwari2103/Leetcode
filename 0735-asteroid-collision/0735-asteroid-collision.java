class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            boolean destroyed=false;//it is for current element
            while(!st.isEmpty() && st.peek()>0 && asteroids[i]<0){
                if(Math.abs(st.peek())<Math.abs(asteroids[i])){
                    st.pop();
                }
                else if(Math.abs(st.peek())==Math.abs(asteroids[i])){
                    st.pop();
                    destroyed=true;
                    break;
                }
                else{
                    destroyed=true;
                    break;

                }
            }
            if(!destroyed){
                st.push(asteroids[i]);
            }
        }
        int m=st.size();
        int[] ans=new int[m];
        for(int i=m-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}