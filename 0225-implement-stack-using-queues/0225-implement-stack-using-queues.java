class MyStack {
    Queue<Integer> q=new ArrayDeque();
    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
        int s=q.size();
        for(int i=1;i<s;i++){
            q.add(q.remove());
        }
    }
    
    public int pop() {
        if(q.isEmpty()) return -1;
        return q.remove();
    }
    
    public int top() {
        if(q.isEmpty()) return -1;
        return q.peek();
    }
    
    public boolean empty() {
       if(q.isEmpty()) return true;
       return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */