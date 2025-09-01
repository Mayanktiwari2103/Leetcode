class Solution {
    public void generate(List<List<String>> ls,List<String> current,int start,String s){
        if(start==s.length()){
            ls.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<s.length();i++){
            String substring=s.substring(start,i+1);
            if(palindrome(substring)){
                 current.add(substring);
                 generate(ls,current,i+1,s);
                 current.remove(current.size()-1);
            }
           
        }
    }
    public boolean palindrome(String s){
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ls=new ArrayList<>();
        generate(ls,new ArrayList<>(),0,s);
        return ls;
    }
}