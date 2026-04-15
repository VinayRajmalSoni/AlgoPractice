class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);

        dfs(0, new ArrayList<>(), 0, nums, target);
        return res;
    }

    private void dfs(int i, List<Integer> slate, int total, int[] nums, int target) {
        if (total == target) {
            res.add(new ArrayList<>(slate));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) {
                return;
            }
            slate.add(nums[j]);
            dfs(j, slate, total + nums[j], nums, target); // we are passing j and not j+1 since same number can be used twice
            slate.remove(slate.size() - 1);
        }
    }
}
