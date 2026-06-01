class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(n<0)  {
            N=-N;
            return 1/pow(x,N);
        }    
        return pow(x,N);
    }

    private double pow(double x , long n){
        if(n==0) return 1;
        if(n==1) return x;
        if(n%2==0){
            return pow(x*x,n/2);
        }
        else{
            return x*pow(x,n-1);
        }
    }
    
}