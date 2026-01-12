class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(n<(long)m*k) return -1;
        int l=Arrays.stream(bloomDay).min().getAsInt();
        int r=Arrays.stream(bloomDay).max().getAsInt();
        while(l<=r){
            int mid=l+(r-l)/2;
            if(bouquets(bloomDay,mid,k)<m){
                l=mid+1;
            }
            else{
                r=mid-1;
            }

        }
        return l;
    }
    public int bouquets(int[] bloomDay,int a,int k){
        int n=bloomDay.length;
        int cnt=0;
        int bouquet=0;
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=a){
                cnt++;

            }
            if(cnt==k){
                bouquet++;
                cnt=0;
            }
            if(bloomDay[i]>a){
                cnt=0;
            }
            
        }
        return bouquet;
    }
}