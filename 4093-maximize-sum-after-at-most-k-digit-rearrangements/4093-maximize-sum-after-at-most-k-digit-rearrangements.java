class Solution {
    private long largest(long number){
        String[] digits=Long.toString(number).split("");
        Arrays.sort(digits,Collections.reverseOrder());
        String sorted=String.join("",digits);
        long result=Long.parseLong(sorted);

        return result;

    }
    public long maximizeSum(int[] nums, int k) {
        int n=nums.length;
        long[][] arr=new long[n][2];
        
        for(int i=0;i<n;i++){
            arr[i][0]=largest(nums[i]);
            arr[i][1]=arr[i][0]-nums[i];
        }

        Arrays.sort(arr,(a,b)-> Long.compare(b[1],a[1]));

        long sum=0;

        for(int i=0;i<n;i++){
            if(k>0){
                sum+=arr[i][0];
                k--;
            }
            else{
                sum+=arr[i][0]-arr[i][1];
            }
        }

        return sum;
    }
}