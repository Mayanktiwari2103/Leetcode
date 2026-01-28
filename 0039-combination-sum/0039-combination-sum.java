class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        generate(candidates,target,result,new ArrayList<>(),0,0);
        return result;
    
    }
    public void generate(int[] candidates, int target, List<List<Integer>> result, List<Integer> list,int sum, int start ){
        if(sum==target){
            result.add(new ArrayList<>(list));

        }
        if(sum> target) return;
        for(int i=start;i<candidates.length;i++){
            list.add(candidates[i]);
            generate(candidates,target,result,list,sum+candidates[i],i);
            list.remove(list.size()-1);
        }
    }

}    
    