class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n=ranks.length;
        long minRank=Arrays.stream(ranks).min().getAsInt();
        long l=1;
        long r=1L * minRank * cars * cars;
        long ans=0;
        while(l<=r){
            long mid=l+(r-l)/2;
            if(number(ranks,mid) >= cars){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }

    private long number(int[] ranks, long time){
        int n=ranks.length;
        long sum=0;
        for(int i=0;i<n;i++){
            sum += (long)Math.sqrt(time / ranks[i]);
        }
        return sum;
    }
}