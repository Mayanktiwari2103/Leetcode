class Solution {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        // code here
        return check(arr, k , 0, 0);
        
    }
    
    private boolean check(int[] arr, int k, int sum ,int ind ){
        if(sum> k) return false;
        if(ind==arr.length){
            return sum==k;
        }
        
        if(check(arr,k,sum+arr[ind],ind+1)){
            return true;
        }
        
        if(check(arr,k,sum,ind+1)){
            return true;
        }
        
        return false;
    }
}