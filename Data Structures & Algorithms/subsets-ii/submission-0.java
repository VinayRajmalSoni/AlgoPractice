class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        //boolean[] used = new boolean[nums.length];
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int num: nums){
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }
        //subsetshelper2(nums, 0, new ArrayList<>(), result, used);
        subsetshelper(nums, 0, new ArrayList<>(), result, countMap);
        return result;
    }
    
    // using count hashmap
    public void subsetshelper(int[] nums, int index, List<Integer> slate, List<List<Integer>> result, HashMap<Integer, Integer> countMap){
        if(index == nums.length){
            result.add(new ArrayList<Integer>(slate));
        }
        else{
            int count = countMap.get(nums[index]);
            // exclude all occurences
            subsetshelper(nums, index + count, slate, result, countMap);             
            // include one, two  and so on copies of the duplicate element
            // for [1, 2, 2] we include one copy of 2, then two copies of 2 i.e[2,2] and then we remove both 2's
            for(int i = 0; i< count; i++){
                slate.add(nums[index]);            
                subsetshelper(nums, index + count, slate, result, countMap);                           
            }
            for(int i = 0; i< count; i++){
                slate.remove(slate.size() - 1);                          
            }
        }
    }
}
