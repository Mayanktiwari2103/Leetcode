class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here
        if(low>=high) return;
        int pidx=partition(arr,low,high);
        quickSort(arr,low,pidx-1);
        quickSort(arr,pidx+1,high);
    }

    private int partition(int[] arr, int low, int high) {
        int l=low-1;
        int pivot=arr[high];
        for(int i=low;i<high;i++){
            if(arr[i] <= pivot){
              l++;
              int temp=arr[l];
              arr[l]=arr[i];
              arr[i]=temp;
            }
        }
        l++;
        int temp=arr[high];
        arr[high]=arr[l];
        arr[l]=temp;
        
        return l;
    }
}