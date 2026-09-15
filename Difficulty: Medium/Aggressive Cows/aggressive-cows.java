class Solution {
    private int cntcows(int[] arr, int cap){
        int n=arr.length;
        int cows=1;
        int last=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]-last >= cap){
                cows++;
                last=arr[i];
            }
        }
        return cows;
    }
    public int aggressiveCows(int[] arr, int k) {
        // code here
        int n=arr.length;
        Arrays.sort(arr);
        int l=1;
        int r=arr[n-1]-arr[0];
        while(l<=r){
            int mid=l+(r-l)/2;
            if(cntcows(arr,mid) < k){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return r;
    }
}