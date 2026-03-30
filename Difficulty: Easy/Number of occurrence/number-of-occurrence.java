class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int prev=first(arr,target);
        int next=last(arr,target);
        return next-prev+1;
        
    }
    public int first(int[] arr, int target){
        int n=arr.length;
        int l=0;
        int r=n-1;
        int firstind=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]==target){
                firstind=mid;
                r=mid-1;
            }
            else if(target > arr[mid]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return firstind==-1 ? 1 : firstind;
    }
    
    public int last(int[] arr, int target){
        int n=arr.length;
        int l=0;
        int r=n-1;
        int lastind=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]==target){
                lastind=mid;
                l=mid+1;
            }
            else if(target > arr[mid]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return lastind==-1 ? 0: lastind;
    }
}
