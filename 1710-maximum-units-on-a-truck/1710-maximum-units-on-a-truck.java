class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n=boxTypes.length;
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);
        
        int sum=0;
        for(int i=0;i<n;i++){
            if(boxTypes[i][0] <= truckSize){
                sum+=boxTypes[i][0]*boxTypes[i][1];
                truckSize-=boxTypes[i][0];
            }
            else{
                sum+=truckSize*(boxTypes[i][1]);
                break;
            }
        }
        return sum;
    }
}