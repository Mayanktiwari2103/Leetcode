class Solution {
    public int minCost(int[] arr) {
        // code here
        int n=arr.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        int sum=0;
        while(pq.size() > 1){
             int first=pq.poll();
             int second=pq.poll();
             sum+=first+second;
             pq.add(first+second);
        }
        return sum;
    }
}