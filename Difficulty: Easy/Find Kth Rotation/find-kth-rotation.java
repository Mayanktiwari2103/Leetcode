class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int n=arr.length;
        int l=0;
        int r=n-1;
        int min=Integer.MAX_VALUE;
        int minind=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[l] <= arr[mid]){
                if(arr[l] < min){
                    min=arr[l];
                    minind=l;
                }
                l=mid+1;
            }
            else{
                if(arr[mid] < min){
                    min=arr[mid];
                    minind=mid;
                }
                r=mid-1;
            }
        }
        return minind;
    }
}