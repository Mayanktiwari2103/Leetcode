class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        generate(n,k,result,new ArrayList<>(),1);
        return result;
    }
    public void generate(int n,int k, List<List<Integer>> result,List<Integer> list,int start){
        if(list.size()==k){
            result.add(new ArrayList<>(list));
        }
        if(list.size()>k){
            return;
        }
        for(int i=start;i<=n;i++){
            list.add(i);
            generate(n,k,result,list,i+1);
            list.remove(list.size()-1);
        }
    }
}