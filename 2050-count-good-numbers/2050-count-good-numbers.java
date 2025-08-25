class Solution {
    static final long M = 1000000007;

    public long findpow(long a, long b) {   // changed int → long
        if (b == 0) return 1;
        long half = findpow(a, b / 2) % M;
        if (b % 2 == 0) {
            return (half * half) % M;       // add modulo at each step
        } else {
            return (half * half % M * (a % M)) % M;
        }
    }

    public int countGoodNumbers(long n) {
        long res = (findpow(5, (n + 1) / 2) * findpow(4, n / 2)) % M;
        return (int) res;   // final answer cast back to int
    }
}
