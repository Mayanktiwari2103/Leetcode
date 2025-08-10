class Solution {
    public int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                freq[c - 'a']++;
                int maxfreq = 0;
                int minfreq = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        maxfreq = Math.max(maxfreq, freq[k]);
                        minfreq = Math.min(minfreq, freq[k]);
                    }

                }
                res += (maxfreq - minfreq);

            }
        }

        return res;

    }
}