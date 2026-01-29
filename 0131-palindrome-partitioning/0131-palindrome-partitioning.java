class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        generate(s,result,new ArrayList<>(),0);
        return result;
    }
    public boolean palindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;

            }
            l++;
            r--;
        }
        return true;
    }
    public void generate(String s,List<List<String>> result,List<String> list,int start){
        if(start==s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(palindrome(s,start,i)){
                list.add(s.substring(start,i+1));
                generate(s,result,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}