class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;
        int cnt1=0,cnt2=0,cnt3=0;
        for(int i=0;i<n;i++){
            if(bills[i]==5){
                cnt1++;
            }
            if(bills[i]==10){
                cnt2++;
                if(cnt1>0){
                    cnt1--;
                }
                else{
                    return false;
                }
            }
            if(bills[i]==20){
                cnt3++;
                if(cnt2>0 && cnt1>0 ){
                    cnt2--;
                    cnt1--;
                }
                else if(cnt1>2){
                    cnt1-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}