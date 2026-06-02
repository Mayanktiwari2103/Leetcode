class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ls=new ArrayList<>();
        generate("",0,0,n,ls);
        return ls;

    }

    private void  generate(String s,int open , int close , int n,List<String> ls){
        if(s.length()==2*n){
           ls.add(s);
           return;
        }
        if(open< n){
            generate(s+"(",open+1,close,n,ls);
        }
        if(close < open){
            generate(s+")",open,close+1,n,ls);
        }
    }
  
}