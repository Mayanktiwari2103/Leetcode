class Solution {
    public int convertTime(String current, String correct) {
        int n=current.length();
        int m=correct.length();
        String parts1[]=current.split(":");
        int hours1=Integer.parseInt(parts1[0]);
        int minutes1=Integer.parseInt(parts1[1]);

        int total1=(hours1*60)+minutes1;

        String parts2[]=correct.split(":");
        int hours2=Integer.parseInt(parts2[0]);
        int minutes2=Integer.parseInt(parts2[1]);

        int total2=(hours2*60)+minutes2;
        int[] min={60,15,5,1};
        int cnt=0;
        int i=0;
        while(total1 < total2){
           if(total1+min[i] <= total2){
            cnt++;
            total1=total1+min[i];
           }
           else{
            i++;
           }
        }
        return cnt;

    }
}