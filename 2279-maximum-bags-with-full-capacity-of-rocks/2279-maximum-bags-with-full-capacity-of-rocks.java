class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;
        long[] ans=new long[n];

        for(int i=0;i<n;i++){
            ans[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(ans);
        long cnt=0;
        for(int i=0;i<n;i++){
           if(additionalRocks >= ans[i]){
            additionalRocks-=ans[i];
            cnt++;
           }
           else{
            break;
           }
            
        }

        return (int)cnt;
    }
}