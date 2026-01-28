class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        generate(k,n,0,result,new ArrayList<>(),1);
        return result;
    }
    public void generate(int k, int n , int sum, List<List<Integer>> result,List<Integer> list,int start){
        if(list.size()==k){
            if(sum==n){
               result.add(new ArrayList<>(list));
               return;
        }

        }
        if(sum>n) return;
        for(int i=start;i<10;i++){
            list.add(i);
            generate(k,n,sum+i,result,list,i+1);
            list.remove(list.size()-1);
        }
    }
}