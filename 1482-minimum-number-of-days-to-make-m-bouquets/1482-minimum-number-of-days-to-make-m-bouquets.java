class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long) m*k > n) return -1;
        int l=Arrays.stream(bloomDay).min().getAsInt();
        int r=Arrays.stream(bloomDay).max().getAsInt();

        while(l<=r){
            int mid=l+(r-l)/2;
            if(cntbouquets(bloomDay,mid,k) < m){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l;
    }

    private int cntbouquets(int[] bloomDay , int days, int k){
        int n=bloomDay.length;
        int bouquet=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(cnt<k){
               if(bloomDay[i] <= days){
                cnt++;
               }
               else{
                cnt=0;
               }
            }
            if(cnt==k){
               bouquet++;
               cnt=0;
            }
        }
        return bouquet;
    }
}