class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int rightProduct = 1;
        leftProduct[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }
        for(int i = nums.length - 2; i >= 0; i--) {
            rightProduct *= nums[i+1];
            leftProduct[i] *= rightProduct; 
        }
        return leftProduct;        
    }
}  
