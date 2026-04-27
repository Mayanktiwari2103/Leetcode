class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n=matrix.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=matrix[i][j];

            }
            arr[i]=sum;
        }
        return arr;
    }
}