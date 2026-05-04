class Solution {
    public boolean isprime(int n){
        if(n<=1) return false;
        for(int i=2;i<(n/2)+1;i++){
            if(n%i==0){
                return false;
            }

        }
        return true;
    }
    public int sumOfPrimesInRange(int n) {
        int reverse=0;
        int m=n;
        while(n>0){
            int digit=n%10;
            reverse=reverse*10+digit;
            n=n/10;
        }
        int min=Math.min(reverse,m);
        int max=Math.max(reverse,m);
        int sum=0;
        for(int i=min;i<=max;i++){
            if(isprime(i)){
                sum+=i;
            }

        }
        return sum;
    }
}