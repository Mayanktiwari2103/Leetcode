class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ls=new ArrayList<>();
       generate(candidates, target,0,0,ls,new ArrayList<>());
       return ls;

    }

    private void generate(int[] candidates, int target,int ind,int sum,List<List<Integer>> ls,List<Integer> list){
        if(sum> target) return;
        if(sum==target){
           ls.add(new ArrayList<>(list));
           return;
        }

        for(int i=ind;i<candidates.length;i++){
            list.add(candidates[i]);
            generate(candidates,target,i,sum+candidates[i],ls,list);
            list.remove(list.size()-1);
        }
    }
    
}    
    