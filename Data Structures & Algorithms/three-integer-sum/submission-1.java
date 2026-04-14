class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] != nums[i-1]){
                twoSum(i, nums, -nums[i], result);
            }
        }
        return result;
    }

    public void twoSum(int i, int[] nums, int target, List<List<Integer>> result) {
        int left = i + 1;
        int right = nums.length - 1;
        while(left < right) {
            if(nums[left] + nums[right] == target) {
                result.add(Arrays.asList(-target, nums[left], nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while(left < right && nums[right] == nums[right + 1]){
                    right--;
                }   
            }
            else if(nums[left] + nums[right] > target) {
                right--;
            }
            else {
                left++;
            }
        }
    }
}
