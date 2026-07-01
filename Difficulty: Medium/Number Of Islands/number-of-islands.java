class Disjoint {
	List<Integer> parent = new ArrayList<>();
	List<Integer> size = new ArrayList<>();
	Disjoint(int n) {
		for (int i = 0; i<n; i++) {
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
		return parent.get(node);
	}
	
	public void unionbysize(int u, int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if (ulp_u == ulp_v)
			return;
		if (size.get(ulp_u) < size.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
			size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
		}
		else {
			parent.set(ulp_v, ulp_u);
			size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
		}
	}
}
class Solution {
	
	private boolean valid(int row, int col,int n,int m) {
		if (row >= 0 && row<n && col >= 0 && col<m) {
			return true;
		}
		return false;
		
	}
	
	public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
		// Your code here
		int n = rows;
		int m = cols;
		Disjoint ds = new Disjoint(n*m+1);
		int cnt = 0;
		int[][] vis=new int[n][m];
		List<Integer> ls = new ArrayList<>();
		for (int[] edge:operators) {
			int row = edge[0];
			int col = edge[1];
			if (vis[row][col] == 1){
			    ls.add(cnt);
			    continue;
			}
			vis[row][col] = 1;
			cnt++;
			int[] drow = {-1, 0, 1, 0};
			int[] dcol = {0, 1, 0, -1};
			for (int i = 0; i<4; i++) {
				int nrow = row + drow[i];
				int ncol = col + dcol[i];
				if (valid(nrow, ncol,n,m)) {
					if (vis[nrow][ncol]==1) {
						int node = row*m + col;
						int adjnode = nrow*m + ncol;
						if (ds.findUPar(node) != ds.findUPar(adjnode)) {
							cnt--;
							ds.unionbysize(node, adjnode);
						}
					}
				}
			}
			ls.add(cnt);
		}
		
		return ls;
		
	}
}
