class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result=new ArrayList<>();
        generate("",n,0,0,result);
        return result;
    }
    public static void generate(String s, int n, int open , int close, ArrayList<String> result){
        if(s.length()==2*n){
            result.add(s);
            return;
        }
        if(open<n){
            generate(s+"(",n,open+1,close,result);
        }
        if(close<open){
            generate(s+")",n,open,close+1,result);
        }

    }
}