class Solution {
    public int calculateScore(int a, int b) {
        StringBuilder sb1=new StringBuilder();
        while(a>0){
            sb1.append(a%2);
            a=a/2;
        }
        sb1=sb1.reverse();

        StringBuilder sb2=new StringBuilder();

        while(b>0){
            sb2.append(b%2);
            b=b/2;
        }

        sb2=sb2.reverse();
        
        int s1=0;
        for(int i=0;i<sb1.length();i++){
           if(sb1.charAt(i)=='1'){
            s1++;
           }
        }
        

        int s2=0;

        for(int i=0;i<sb2.length();i++){
            if(sb2.charAt(i)=='1'){
                s2++;
            }
        }

        if(s1>=s2){
            return s1*s2;
        }

        return s2/s1;

    }
}