class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> ls=new ArrayList<>();
        generate(ls,new String(),n,k,0,0);
        return ls;
    }

    private void generate( List<String> ls, String s, int n , int k,int sum,int ind){
        if(sum> k){
            return;
        }
        if(s.length()==n){
            ls.add(s);
            return;
        }
        generate(ls,s+"0",n,k,sum,ind+1);
        if(s.length()==0 || s.charAt(s.length()-1)!='1'){
            generate(ls,s+"1",n,k,sum+ind,ind+1);
        }
    }
}