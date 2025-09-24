class Solution {
   
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Character> st=new Stack();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && k>0 && (st.peek()-'0')>(num.charAt(i)-'0')){
                st.pop();
                k=k-1;
            }
            st.push(num.charAt(i));
        }
        //edge cases
         while(k>0){// when the number is sorted
            st.pop();
            k--;
         }
         if(st.isEmpty()){
            return "0";
         }
         while(!st.isEmpty()){
            res.append(st.pop());
         }
         res.reverse();
         while(res.length()!=0 && res.charAt(0)=='0'){
            res.deleteCharAt(0);
         }
         return res.length()==0 ? "0" :res.toString();


    
    }
}