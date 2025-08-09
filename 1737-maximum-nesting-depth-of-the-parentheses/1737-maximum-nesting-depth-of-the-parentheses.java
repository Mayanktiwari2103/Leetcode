class Solution {
    public int maxDepth(String s) {
        int count=0;
        int maxcount=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                count++;
                maxcount=Math.max(count,maxcount);
            }
            else if(c==')'){
                count--;
            }
            
        }
        return maxcount;
        
    }
}