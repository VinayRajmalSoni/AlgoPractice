class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int itr = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.addLast(right);
            if (deque.peekFirst() < right - k + 1) {
                deque.pollFirst();
            }
            if((right - left + 1) >= k) {
                result[itr++] = nums[deque.peekFirst()];
            }
        }
        return result;        
    }
}