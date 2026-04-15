class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> slate = new ArrayList<>();
        dfs(nums, 0, slate, res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> slate, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(slate));
            return;
        }

        // exclude
        dfs(nums, i + 1, slate, res);

        // include the number
        slate.add(nums[i]);
        dfs(nums, i + 1, slate, res);
        slate.remove(slate.size() - 1);        
    }
}
