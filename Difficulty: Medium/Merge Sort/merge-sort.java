class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if(l>=r) return;
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
        
    }
    
    public void merge(int[] arr,int low, int mid,int high){
        int n=arr.length;
        int[] temp=new int[high-low+1];
        int k=0;
        int l=low;
        int r=mid+1;
        while(l<=mid && r<=high){
            if(arr[l]<=arr[r]){
                temp[k++]=arr[l++];
            }
            else{
                temp[k++]=arr[r++];
            }
        }
        while(l<=mid){
            temp[k++]=arr[l++];
        }
        while(r<=high){
            temp[k++]=arr[r++];
        }
        
        for(int i=0;i<temp.length;i++){
            arr[low+i]=temp[i];
        }
    }
    
}