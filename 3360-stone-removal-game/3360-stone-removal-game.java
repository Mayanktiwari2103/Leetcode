class Solution {
    public boolean canAliceWin(int n) {
        int t=0;
        int hold=10;
        while(n >=hold){
            n-=hold--;
            t^=1;
        }

        return t==1?true:false;
    }
}