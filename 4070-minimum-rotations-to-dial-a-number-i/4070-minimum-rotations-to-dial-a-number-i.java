class Solution {
    public int minRotations(String s) {
        int n=s.length();
        int rotation=0;
        int pointer=0;
        for(int i=0;i<n;i++){
            int digit=s.charAt(i)-'0';
            int difference=Math.abs(digit-pointer);
            int circulardiff=10-Math.abs(digit-pointer);
            rotation+=Math.min(difference,circulardiff);
            pointer=digit;
        }
        return rotation;
    }
}