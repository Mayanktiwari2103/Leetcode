class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        int n=s.length();
        for(int i=1;i<n;i++){
            if(Math.abs(s.charAt(i)-s.charAt(i-1))>2){
                return false;
            }
        }
        return true;
    }
}