class StockSpanner {
    static class Pair{
        int price;
        int index;
        Pair(int price,int index){
            this.price=price;
            this.index=index;
        }
    }
    Stack<Pair> st;
    int ind;

    public StockSpanner() {
        ind=-1;
        st=new Stack<>();
    }
    
    public int next(int price) {
        ind=ind+1;
        int ans=0;
        while(!st.isEmpty() && st.peek().price<=price){
            st.pop();
        }
        if(st.isEmpty()){
            ans=ind+1;
        }
        else{
            ans=ind-st.peek().index;
        }
        st.push(new Pair(price,ind));
        return ans;

        
    }
    
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */