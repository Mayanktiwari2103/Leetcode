class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] result=new int[10001];
        Stack<Integer> st=new Stack();
        for(int i=m-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                result[nums2[i]]=-1;
            }
            else{
                result[nums2[i]]=st.peek();
            }
            st.push(nums2[i]);
        }
        for(int i=0;i<n;i++){
            nums1[i]=result[nums1[i]];

        }
        return nums1;

    }
}