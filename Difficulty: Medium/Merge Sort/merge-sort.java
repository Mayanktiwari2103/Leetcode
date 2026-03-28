class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if(l>=r) return;
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
        
    }
    public void merge(int[] arr, int low,int mid, int right){
        int n=arr.length;
        int a=low;
        int b=mid+1;
        int[] temp=new int[right-low+1];
        int k=0;
        while(a<=mid && b<=right ){
            if(arr[a]<=arr[b]){
                temp[k++]=arr[a++];
            }
            else{
                temp[k++]=arr[b++];
            }
        }
        while(a<=mid){
            temp[k++]=arr[a++];
        }
        while(b<= right){
            temp[k++]=arr[b++];
        }
        
        for(int i=0;i<temp.length;i++){
            arr[low+i]=temp[i];
        }
    }
    
    
}