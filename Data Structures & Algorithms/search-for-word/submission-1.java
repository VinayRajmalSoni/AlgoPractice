class Solution {
    /*Correct Complexity
    O(n * m * 4^L)
    Where:

    n * m = number of starting cells
    4^L = max DFS paths per cell (4 branches, L levels deep)*/
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        // start at every cell as a seed and do a depth first traversal of the entire graph from that point
        for (int x=0; x<board.length; x++) {
            for (int y=0; y<board[x].length; y++) {
                if (exist(board, x, y, w, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, char[] word, int i, boolean[][] visited) {
        if (i == word.length) return true;
        if (y<0 || x<0 || x == board.length || y == board[x].length || visited[x][y]) return false;
        if (board[x][y] != word[i]) return false;
        // another option is to exor with 256 to make sure this doesnt get used again
        // 256 coz we assume each char can fit in the range of 1-128
        // visited is marked as true so that we dont iterate again from this cell
        // from a different neighbor
        visited[x][y] = true;
        boolean exist = exist(board, x, y+1, word, i+1, visited)
            || exist(board, x, y-1, word, i+1, visited)
            || exist(board, x+1, y, word, i+1, visited)
            || exist(board, x-1, y, word, i+1, visited);
        // reset the char for use by other iterations.
        // word was not found, but this cell can be used to find word when
        // starting from another cell. Hence set this to false.
        visited[x][y] = false;
        return exist;
    }
}
