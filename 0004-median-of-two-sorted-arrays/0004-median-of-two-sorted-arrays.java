class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int total = n + m;
        int count = 0;
        int i = 0, j = 0;
        int index2 = total / 2;
        int index1 = index2 - 1;
        int ind1el = 0, ind2el = 0;

        while (i < n && j < m) {
            int val;
            if (nums1[i] < nums2[j]) {
                val = nums1[i++];
            } else {
                val = nums2[j++];
            }

            if (count == index1) ind1el = val;
            if (count == index2) ind2el = val;
            count++;
        }

        while (i < n) {
            int val = nums1[i++];
            if (count == index1) ind1el = val;
            if (count == index2) ind2el = val;
            count++;
        }

        while (j < m) {
            int val = nums2[j++];
            if (count == index1) ind1el = val;
            if (count == index2) ind2el = val;
            count++;
        }

        if (total % 2 == 0) {
            return (ind1el + ind2el) / 2.0;
        } else {
            return ind2el;
        }
    }
}
