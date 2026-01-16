class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m) return false;
        HashMap<Character,Character> map1=new HashMap<>();
        HashMap<Character,Character> map2=new HashMap<>();
        for(int i=0;i<n;i++){
            char a=s.charAt(i);
            char b=t.charAt(i);
            if(map1.containsKey(a)){
                if(map1.get(a)!=b) return false;
            }
            else{
                map1.put(a,b);
            }

            if(map2.containsKey(b)){
                if(map2.get(b)!=a) return false;
            }
            else{
                map2.put(b,a);
            }
        }
        
        
        return  true;
    }
}