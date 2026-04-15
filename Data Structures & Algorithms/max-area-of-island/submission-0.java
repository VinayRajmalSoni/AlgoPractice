class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {                
                if(grid[i][j] == 1){
                     max = Math.max(max, DFSMark(grid, i, j));
                }
            }
        }
        return max;        
    }
    
    public int DFSMark(int[][] grid, int i, int j)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1){
            return 0;
        }

        grid[i][j] = 0;
        int down = DFSMark(grid, i + 1, j);
        int up = DFSMark(grid, i - 1, j);
        int right = DFSMark(grid, i, j + 1);
        int left = DFSMark(grid, i, j - 1);
        int result = 1 + left + right + up + down;
        return result;
    }
}
