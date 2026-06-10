class Solution {
    public List<String> validStrings(int n) {
        List<String> ls=new ArrayList<>();
        generate(ls,new String(),n);
        return ls;
    }

    private void generate(List<String> ls, String s , int n ){
        if(s.length()==n){
            ls.add(s);
            return;
        }
        generate(ls,s+"1",n);
        if(s.length()==0 || s.charAt(s.length()-1)!='0'){
            generate(ls,s+"0",n);
        }
    }
}