class Solution {
    int replaceBit(int n, int k) {
        int bits = Integer.SIZE - Integer.numberOfLeadingZeros(n);

        if (k > bits) {
            return n;
        }

        int rightIndex = bits - k;
        return n & ~(1 << rightIndex);
    }
}