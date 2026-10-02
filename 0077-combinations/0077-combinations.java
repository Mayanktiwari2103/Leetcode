class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ls=new ArrayList<>();
        generate(n,k,ls,1,new ArrayList<>());
        return ls;
    }

    private void generate(int n , int k , List<List<Integer>> ls,int ind, List<Integer> list){
        if(list.size()==k){
            ls.add(new ArrayList<>(list));
        }
        if(list.size() >k){
            return;
        }
        for(int i=ind;i<=n;i++){
            list.add(i);
            generate(n,k,ls,i+1,list);
            list.remove(list.size()-1);
        }
    }
    
}