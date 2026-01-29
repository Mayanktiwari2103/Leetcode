class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map=new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result=new ArrayList<>();
        generate(digits,result,new StringBuilder(),0,map);
        return result;
    }

    public void generate(String digits,List<String> result,StringBuilder sb,int start,HashMap<Character,String> map){

        if(start==digits.length()){
            result.add(sb.toString());
            return;
        }
        String letters=map.get(digits.charAt(start));
        for(char j=0;j<letters.length();j++){  
            char c=letters.charAt(j);         
            sb.append(c);
            generate(digits,result,sb,start+1,map);
            sb.deleteCharAt(sb.length()-1);
        }


    }
}