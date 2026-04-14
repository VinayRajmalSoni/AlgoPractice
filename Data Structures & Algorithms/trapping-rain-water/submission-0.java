class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int max = 0;
        int totalWater = 0;
        for(int i = 0; i < height.length; i++) {
            leftMax[i] = max;
            if(height[i] > max) {
                max = height[i];
            }
        }

        max = 0;
        for(int i = height.length - 1; i >=0; i--) {
            totalWater += Math.max(0, Math.min(max, leftMax[i])-height[i]);
            if(height[i] > max) {
                max = height[i];
            }
        }
        return totalWater;        
    }
}
