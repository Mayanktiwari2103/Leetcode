class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if (s.isEmpty()) return 0;
        int start=0;
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            start=1;
        }
        int res=0;
        for(int i=start;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='0' && c<='9'){
                int d=c-'0';
                if (res > (Integer.MAX_VALUE - d) / 10) {
                    return (s.charAt(0) == '-') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res=res*10+d;


            }
            else{
                break;
            }
        }
        if(s.charAt(0)=='-'){
            return -res;
        }
        else{
            return res;
        }

        
    
    }
}