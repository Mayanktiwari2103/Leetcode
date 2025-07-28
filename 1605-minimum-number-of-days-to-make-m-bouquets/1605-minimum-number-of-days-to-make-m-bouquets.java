class Solution {
    public boolean possible(int[] bloomDay,int days,int m,int k){
        int n=bloomDay.length;
        int count=0;
        int nofbouq=0;
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=days){
                count++;
            }
            else{
                nofbouq+=(count/k);
                count=0;
            }
        }
        nofbouq+=(count/k);
        return nofbouq>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int low=Arrays.stream(bloomDay).min().getAsInt();
        int high=Arrays.stream(bloomDay).max().getAsInt();
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            boolean min=possible(bloomDay,mid,m,k);
            if(min){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return ans;
        
    }
}