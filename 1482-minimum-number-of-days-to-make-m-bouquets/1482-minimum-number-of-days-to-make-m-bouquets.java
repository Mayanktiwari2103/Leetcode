class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int l = Arrays.stream(bloomDay).min().getAsInt();
        int r = Arrays.stream(bloomDay).max().getAsInt();
        if ((long) m * k > n)
            return -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (possible(bloomDay, m, k, mid) < m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private int possible(int[] bloomDay, int m, int k, int day) {
        int n = bloomDay.length;
        int bouquet = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(bloomDay[i] <= day) cnt++;
            if(cnt==k){
              bouquet++;
              cnt=0;
            }
            if(bloomDay[i] > day) cnt=0;

        }
        return bouquet;
    }
}