class Solution {

    static final long M = 1000000007;

    public long pow(long x, long n) {

        if (n == 0) return 1;

        if (n % 2 == 0) {
            return pow((x * x) % M, n / 2) % M;
        } else {
            return (x % M * pow(x, n - 1) % M) % M;
        }
    }

    public int countGoodNumbers(long n) {

        long res = (pow(5, (n + 1) / 2) * pow(4, n / 2)) % M;

        return (int) res;
    }
}
