class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int n=arr.length;
        int l=Arrays.stream(arr).max().getAsInt();
        int r=Arrays.stream(arr).sum();
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(possible(arr,k,mid) <= k){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        
        return ans;
    }
    
    private int possible(int[] arr, int k , int cap){
        int n=arr.length;
        int painter=1;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum > cap){
                painter++;
                sum=arr[i];
            }
        }
        return painter;
    }
}
