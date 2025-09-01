class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ls=new ArrayList<>();
        if (digits == null || digits.length() == 0) return ls;
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        generate(ls,digits,map,new StringBuilder(),0);
        return ls;
    }  
    public void generate(List<String> ls,String digits, HashMap<Character,String> map,StringBuilder current,int start){
        if(current.length()==digits.length()){
            ls.add(current.toString());
            return;
        }
        String letter=map.get(digits.charAt(start));
        for(char c: letter.toCharArray()){
            current.append(c);
            generate(ls,digits,map,current,start+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}
