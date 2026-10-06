class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        int cnt=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                st.push('(');
            }
            else if(!st.isEmpty() && st.peek()=='('){
                st.pop();
            }
            else{
                cnt++;
            }
        }

        return cnt+st.size();
    }
}