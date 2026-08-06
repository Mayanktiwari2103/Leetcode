class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        int n=arr.length;
        if(n < k) return -1;
        long l=Arrays.stream(arr).max().getAsInt();
        long r=0;
        for (int x : arr)
          r += x;
        long ans=-1;
        while(l<=r){
            long mid=l+(r-l)/2;
            if(possible(arr,k,mid) <= k){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
            
        }
        return (int) ans;
    }
    
    private int possible(int[] arr, int k , long pages){
        int n=arr.length;
        int student=1;
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum > pages){
                student++;
                sum=arr[i];
            }
        }
        return student;
    }
}