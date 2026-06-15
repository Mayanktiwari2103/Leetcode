class Solution {
    public boolean checkGoodInteger(int n) {
        String s=Integer.toString(n);
        int digitsum=0;
        int squaresum=0;
        for(int i=0;i<s.length();i++){
            int digit=s.charAt(i)-'0';
            digitsum+=digit;
            squaresum+=digit*digit;
        }

        if(squaresum-digitsum < 50){
            return false;
        }
        return true;
    }
}