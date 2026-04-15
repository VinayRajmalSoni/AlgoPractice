class WordDictionary {
    // initialize a TRIE class  
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    
    private TrieNode root = new TrieNode();

    // add word
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        
        // make sure word is set as this is the value at the node 
        // if this is empty it means its not a word.
        node.item = word;
    }

    public boolean search(String word) {
        // start from 0 location of the word
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chs, int k, TrieNode node) {
        // if we reach length we want to be sure the word or item here is not empty
        // we cannot compare directly with word here since the word can contain wildcard
        // because root is not the first character, we have the base condition as k == chs.length
        // if root were first char, then base condition would be k == chs.length - 1
        if (k == chs.length)
            return !node.item.equals("");   
        
        // if the char is not . then we recursively call the 
        if (chs[k] != '.') {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

