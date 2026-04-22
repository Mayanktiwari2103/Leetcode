import java.util.*;

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int upl = findUPar(parent.get(node));
        parent.set(node, upl);
        return upl;
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {

        int n = stones.length;

        int maxRow = 0, maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);

        HashSet<Integer> nodes = new HashSet<>();

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1;

            ds.unionBySize(row, col);

            nodes.add(row);
            nodes.add(col);
        }

        int components = 0;

        for (int node : nodes) {
            if (ds.findUPar(node) == node) {
                components++;
            }
        }

        return n - components;
    }
}