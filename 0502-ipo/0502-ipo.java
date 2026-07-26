class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int[][] ventures=new int[n][2];
        for(int i=0;i<n;i++){
            ventures[i][0]=capital[i];
            ventures[i][1]=profits[i];
        }
        Arrays.sort(ventures, (a,b)-> a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int ind=0;
        int money=w;
        for(int i=0;i<k;i++){
            while(ind < n && ventures[ind][0] <=money){
               pq.add(ventures[ind][1]);
               ind++;
            }
            if(pq.isEmpty()) break;
            money+=pq.poll();
        }
        return money;
    }
}