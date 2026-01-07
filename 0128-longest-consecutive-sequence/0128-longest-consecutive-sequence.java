class Solution {
    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        if(n==0) return 0;
        int cnt = 0;
        int maxcnt = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (int it : set) {
            if (!set.contains(it - 1)) {
                cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    cnt++;
                    x = x + 1;
                }
                maxcnt = Math.max(cnt, maxcnt);
            }

        }
        return maxcnt;
    }
}