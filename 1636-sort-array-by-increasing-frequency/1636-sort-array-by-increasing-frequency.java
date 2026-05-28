class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (map.get(a).equals(map.get(b))) {
                        return b - a;
                    }
                    return map.get(a) - map.get(b);
                });
        pq.addAll(map.keySet());
        int[] answer = new int[n];
        int ind = 0;
        while (!pq.isEmpty()) {
            int c = pq.poll();
            int freq = map.get(c);
            for (int i = 0; i < freq; i++) {
                answer[ind++] = c;
            }
        }

        return answer;
    }
}