class TrieNode {
    char ch;
    boolean isWord;
    TrieNode[] children;

    public TrieNode(char ch){
        this.ch = ch;   
        this.isWord = false;
        this.children = new TrieNode[26];     
    }
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode(' ');        
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            if(node.children[ch-'a'] == null){
                node.children[ch-'a'] = new TrieNode(ch);
            }
            node = node.children[ch-'a'];
        }
        node.isWord = true;        
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            if(node.children[ch-'a'] == null){
                return false;
            }
            node = node.children[ch-'a'];
        }
        return node.isWord;        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch: prefix.toCharArray()){
            if(node.children[ch-'a'] == null){
                return false;
            }
            node = node.children[ch-'a'];
        }
        return true;
    }
}
