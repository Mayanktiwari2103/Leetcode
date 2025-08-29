class Solution {
    public void generate(List<List<Integer>> ls,int[] candidates,int target,List<Integer> list,int start,int sum){
        int n=candidates.length;
         if(sum==target){
            ls.add(new ArrayList<>(list));
            return;
        }
        if(sum>target) return;
       
        for(int i=start;i<n;i++){
            list.add(candidates[i]);
            generate(ls,candidates,target,list,i,sum+candidates[i]);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ls=new ArrayList<>();
        generate(ls,candidates,target,new ArrayList<>(),0,0);
        return ls;
    }
}