class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n=val.length;
        int m=wt.length;
        double[][] items =new double[n][2];
        
        for(int i=0;i<n;i++){
            items[i][0]=val[i];
            items[i][1]=wt[i];
        }
        
        Arrays.sort(items , (a,b) -> Double.compare(b[0]/b[1] , a[0]/a[1]));
        
        double sum=0;
        for(int i=0;i<n;i++){
            if(items[i][1] <= capacity){
                sum+=items[i][0];
                capacity-=items[i][1];
            }
            else{
                sum+=capacity* (items[i][0]/items[i][1]);
                break;
            }
        }
        return sum;
    }
}