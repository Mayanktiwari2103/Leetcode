class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        int x1=source[0];
        int x2=source[1];
        int y1=target[0];
        int y2=target[1];

        if(x1==y1 && x2==y2){
            return 0;
        }

        if(x1==y1 || x2==y2 || Math.pow((y1-x1),2)==Math.pow((y2-x2),2)){
            return 1;
        }

        return 2;

    }
}