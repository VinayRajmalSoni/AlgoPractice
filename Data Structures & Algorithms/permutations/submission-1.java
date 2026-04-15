class Solution {
    // O(n!*n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, new ArrayList<Integer>(), result, used);        
        return result;        
    }
    public void permuteHelper(int[] nums, List<Integer> slate, List<List<Integer>> result, boolean[] used){
        if(slate.size() == nums.length){
            result.add(new ArrayList<Integer>(slate));
            return;
        }
        else{
            for(int i = 0; i< nums.length; i++){
                if(used[i] == false){
                    slate.add(nums[i]);
                    used[i] = true;
                    permuteHelper(nums, slate, result, used);
                    used[i] = false;
                    slate.remove(slate.size() - 1);// by default add in Arraylist adds to end of list
                }
            }
        }
    }   
}
