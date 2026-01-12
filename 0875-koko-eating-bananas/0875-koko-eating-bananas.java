class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (findk(piles, mid) <= h) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return l;
    }

    public int findk(int[] piles, int k) {
        int n = piles.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil(piles[i] / (double)k);

        }

        return sum;

    }
}