class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        int l = 0, r = ROWS * COLS - 1;
        /*
        The way to think about it is if you have 6 total items and you only have 3 columns per row, then how many rows do you need to fit 6 items.
        The answer is obviously totalItems divided by number of columns i.e. 6 / 3.
        So thats how you find the row index of an item ( pivotIndex / columns ) and the mod operator gives you the offset into the column,
        for instance if you have 6 items and 3 columns then obviously the 6th item will be the last item and in the last column.
        Hence 6 % 3 would give you 2 i.e. its in the column index 2 (0-indexed) which is the 3rd column.
            */        
        while (l <= r) {
            int m = l + (r - l) / 2;
            int row = m / COLS, col = m % COLS;
            if (target > matrix[row][col]) {
                l = m + 1;
            } else if (target < matrix[row][col]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
        
    }
}
