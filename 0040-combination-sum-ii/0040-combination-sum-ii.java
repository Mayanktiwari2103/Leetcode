class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        generate(candidates,target,result,new ArrayList<>(),0,0);
        return result;
    }
    public void generate(int[] candidates, int target, List<List<Integer>> result,List<Integer> list,int sum,int start){
        if(sum==target){
            result.add(new ArrayList<>(list));
        }
        if(sum>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]) continue;
            list.add(candidates[i]);
            generate(candidates,target,result,list,sum+candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }
}