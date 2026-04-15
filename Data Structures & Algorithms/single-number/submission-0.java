class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num; // exor operation will remove the numbers which occur twice
        }
        return res;
        
    }
}
