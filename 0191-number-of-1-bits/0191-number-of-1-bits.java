class Solution {
    public int hammingWeight(int n) {
        StringBuilder sb=new StringBuilder();
        while(n!=0){
            sb.append(n%2);
            n=n/2;
        }
        sb=sb.reverse();
        int m=sb.length();
        int cnt=0;
        for(int i=0;i<m;i++){
            if(sb.charAt(i)=='1') cnt++;
        }
        return cnt;
    }
}