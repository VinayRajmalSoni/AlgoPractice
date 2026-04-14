class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        // get max value in array
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r; // start with the max you can. This might not be correct if max doesnt allow for finishing with h time

        while (l <= r) {
            int m = (l + r) / 2;

            long totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / m);
            }
            if (totalTime <= h) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;        
    }
}
