class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        long N=n;
        if(n<0){
            x=1/x;
            N=-N;
        }
        return pow(x,N);
    }
    public double pow(double x, long n){
        if(n==0) return 1;
        if(n%2==0){
            return pow(x*x,n/2);
        } 
        else{
            return x*pow(x,n-1);
        }
        
    }
}