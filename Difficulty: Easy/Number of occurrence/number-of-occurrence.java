class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int prev=first(arr,target);
        int next=last(arr,target);
        return next-prev+1;
       
    }
    
    private int first(int[] arr, int target){
        int n=arr.length;
        int l=0;
        int r=n-1;
        int first=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==target){
                first=mid;
                r=mid-1;
            }
            else if(arr[mid] < target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return first;
    }
    
    private int last(int[] arr, int target){
        int n=arr.length;
        int l=0;
        int r=n-1;
        int last=-2;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==target){
                last=mid;
                l=mid+1;
            }
            else if(arr[mid] < target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return last;
    }
    
}
