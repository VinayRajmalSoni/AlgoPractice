class Solution {
    /*
        The Core Idea
    After sorting: [1, 2, 2, 2, 5]

    The condition skips duplicates only at the same recursion level, but not across levels (which is how [1,2,2] gets included).

    Trace Through
    Building [1, 2, 2]:

    Level	start	i	Condition i > start?	Action
    0	0	0	No (i == start)	Pick 1
    1	1	1	No (i == start)	Pick first 2
    2	2	2	No (i == start)	Pick second 2 ✅
    Since i == start at each level, the skip never triggers → [1,2,2] is found!

    Why third 2 (index 3) is skipped at Level 2:

    At Level 2 (start=2), the loop reaches i=3:

    nums[3] == nums[2] ✓
    i(3) > start(2) ✓
    → Skip! (Would give duplicate [1,2,2] again)
    The Mental Model
    i > start means: "Have I already tried this value earlier in this same loop iteration?"

    Same level, same value → skip (prevents duplicate combinations)
    Different levels, same value → allowed (enables [1,2,2])
    */
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    private void backtrack(List<List<Integer>> list, List<Integer> slate, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(slate));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                slate.add(nums[i]);
                backtrack(list, slate, nums, remain - nums[i], i + 1);
                slate.remove(slate.size() - 1); 
            }
        }
    }
}