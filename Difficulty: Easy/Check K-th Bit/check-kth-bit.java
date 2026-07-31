class CheckBit {
    static boolean checkKthBit(int n, int k) {
        // code here
        n=n >> k;
        if((n&1)!=0) return true;
        return false;
    }
}