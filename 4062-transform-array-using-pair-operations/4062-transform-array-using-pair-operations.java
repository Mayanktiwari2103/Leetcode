class Solution {
    public boolean canTransform(int[] source, int[] target) {
        int n=source.length;
        int m=target.length;

        long sum1=0;
        for(int i=0;i<n;i++){
            sum1+=source[i];
        }

        for(int j=0;j<m;j++){
            sum1-=target[j];
        }

        if(sum1==0){
            return true;
        }
        return false;
    }
}