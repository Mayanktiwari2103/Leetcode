class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {      
        List<List<Integer>> ls=new ArrayList<>();
        generate(candidates,ls,new ArrayList<>(),0,0,target);
        return ls;
    }     

    private void generate(int[] candidates ,List<List<Integer>> ls ,List<Integer> list ,int sum,int ind,int target){
        if(sum==target){
            ls.add(new ArrayList<>(list));
        }
        if(sum > target){
            return;
        }

        for(int i=ind;i<candidates.length;i++){
            list.add(candidates[i]);
            generate(candidates,ls,list,sum+candidates[i],i,target);
            list.remove(list.size()-1);
        }
    }  
}    
    