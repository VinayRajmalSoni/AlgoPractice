public class Solution {
    // Similar question: https://leetcode.com/problems/word-search/
    // difference is the other problem only has one word to search
    // which we could do using DFS since using trie for one work will be overkill
    // however here we have multiple words to search which will require using an outer for loop of words
    // increasing the time complexity
    // hence we use trie here and add whatever words we can reach from each cell as the start into the result
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;

        char c = board[i][j];
        if (c == '#' || p.children[c - 'a'] == null) return;
        p = p.children[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate or use set for result
        }

        board[i][j] = '#'; // marking as visited
        dfs(board, i - 1, j ,p, res); 
        dfs(board, i, j - 1, p, res);
        dfs(board, i + 1, j, p, res); 
        dfs(board, i, j + 1, p, res); 
        board[i][j] = c; // unmark the visited step, in case word doesnt start from here.
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.children[i] == null) p.children[i] = new TrieNode();
                p = p.children[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}