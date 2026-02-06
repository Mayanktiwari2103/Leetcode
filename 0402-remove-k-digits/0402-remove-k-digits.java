class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k > 0 && st.peek() >num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0) return "0";
        return sb.toString();
    }
}