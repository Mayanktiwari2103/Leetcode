class Solution {
    public int maxelem(int[][] mat, int col){
        int n=mat.length;
        int maxvalue=-1;
        int maxindex=-1;
        for(int i=0;i<n;i++){
            if(mat[i][col]>maxvalue){
                maxvalue=mat[i][col];
                maxindex=i;
            }
        }
        return maxindex;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int l=0;
        int r=m-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int maxrow=maxelem(mat,mid);
            int left=mid-1>=0 ?mat[maxrow][mid-1]:-1;
            int right=mid+1<m ?mat[maxrow][mid+1]:-1;
            if(mat[maxrow][mid]>left && mat[maxrow][mid]>right){
                return new int[]{maxrow,mid};
            }
            else if(mat[maxrow][mid]<left){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}