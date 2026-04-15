class Solution {
    // Complexity: Same as DFS — O(m × n) time and space.
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {                
                if(grid[i][j] == '1'){
                    DFSMark(grid, i, j);
                    //bfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;        
    }
    
    public void DFSMark(char[][] grid, int i, int j)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = 'X'; // mark the node as visited and include it as part of the island
        DFSMark(grid, i + 1, j); // next row
        DFSMark(grid, i - 1, j); // prev row
        DFSMark(grid, i, j + 1); // next col
        DFSMark(grid, i, j - 1); // prev col
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        grid[r][c] = '0';

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int nr = cell[0] + d[0];
                int nc = cell[1] + d[1];
                if (nr >= 0 && nr < grid.length &&
                    nc >= 0 && nc < grid[0].length &&
                    grid[nr][nc] == '1') {
                    // set the cell to 0 and add the new row and new col to queue for BFS    
                    grid[nr][nc] = '0';
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}