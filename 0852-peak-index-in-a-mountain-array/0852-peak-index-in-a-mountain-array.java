class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        if(arr[0] > arr[1]) return 0;
        int l=1;
        int r=n-2;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid-1] < arr[mid] && arr[mid+1]< arr[mid]){
                return mid;
            }
            else if(arr[mid-1] < arr[mid]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }
}