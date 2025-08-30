class Solution {
    public void generate(List<List<Integer>> ls,int k, int n,List<Integer> list,int start,int sum){
        if(list.size()==k && sum==n){
            ls.add(new ArrayList<>(list));
            return ;
        }
        if(sum>n) return ;
        for(int i=start;i<10;i++){
            list.add(i);
            generate(ls,k,n,list,i+1,sum+i);
            list.remove(list.size()-1);

        }

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ls=new ArrayList<>();
        generate(ls,k,n,new ArrayList<>(),1,0);
        return ls;
    }
}