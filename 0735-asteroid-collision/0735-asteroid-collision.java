class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(asteroids[i]<0){
                while(!st.isEmpty() && st.peek()>0 && st.peek()<(Math.abs(asteroids[i]))){
                    st.pop();
                }
                if(st.isEmpty()){
                    st.push(asteroids[i]);
                }
                else if(st.peek()<0){
                    st.push(asteroids[i]);

                }
                else if(st.peek()==Math.abs(asteroids[i])){
                    st.pop();

                }
                else{
                    continue;
                }
            }
            else{
                st.push(asteroids[i]);
            }


        }
        int[] ans=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}