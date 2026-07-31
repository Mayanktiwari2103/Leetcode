class CheckBit {
    static boolean checkKthBit(int n, int k) {
        // code here
        StringBuilder sb=new StringBuilder();
        while(n!=0){
            sb.append(n%2);
            n=n/2;
        }
        sb=sb.reverse();
        int m=sb.length();
        if(m <= k) return false;
        if(sb.charAt(m-1-k)=='1') return true;
        return false;
    }
}