class Solution {
    public void generate( List<String> result,int n,int open,int close,String str){
        if(str.length()==(2*n)){
            result.add(str);
            return;
 
        }
        if(open<n){
            generate(result,n,open+1,close,str+"(");
        }
        if(close<open){
            generate(result,n,open,close+1,str+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        generate(result,n,0,0,"");
        return result;
        

    }
}