class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] freq = new int[101];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.first - b.first);

        for (int i = 1; i < 101; i++) {
            if (freq[i] >= 1) {
                pq.add(new Pair(i, freq[i]));
            }
        }

        int j = 0;

        while (!pq.isEmpty()) {

            int size = pq.size();
            Pair[] temp = new Pair[size];

            for (int i = 0; i < size; i++) {

                Pair p = pq.poll();

                ans[j++] = p.first;
                p.second--;

                if (p.second > 0) {
                    temp[i] = p;
                }
            }

            for (int i = 0; i < size; i++) {
                if (temp[i] != null) {
                    pq.add(temp[i]);
                }
            }
        }

        return ans;
    }
}