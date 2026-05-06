class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for(int num: nums) {
            set.add(num);
        }

        for(int num: nums) {
            // this is not the start point
            if(set.contains(num - 1)){
                continue;
            }
            else {
                // this is the start point
                int count = 1;
                int check = num;
                while(set.contains(check + 1)) {
                    count++;
                    check++;
                }
                result = Math.max(result, count);
            }
        }
        return result;        
    }
}
