class Solution {
    // iterative find exact binary search
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + ((r - l) / 2);
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    // upper bound finds the first index where a value greater than the target appears.
    public int search_upper(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int m = l + ((r - l) / 2);
            if (nums[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return (l > 0 && nums[l - 1] == target) ? l - 1 : -1;
    }

    // lower bound finds the first index where a value is greater than or equal to the target.
    public int search_lower_bound(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return (l < nums.length && nums[l] == target) ? l : -1;
    }

    // recursive solution
    public int binary_search_recursive(int l, int r, int[] nums, int target) {
        if (l > r) return -1;
        int m = l + (r - l) / 2;

        if (nums[m] == target) return m;
        return (nums[m] < target) ?
            binary_search_recursive(m + 1, r, nums, target) :
            binary_search_recursive(l, m - 1, nums, target);
    }

    public int search_recursive(int[] nums, int target) {
        return binary_search_recursive(0, nums.length - 1, nums, target);
    }
}
