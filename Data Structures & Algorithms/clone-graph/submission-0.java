/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> cloneMap = new HashMap<Node, Node>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        
        if(cloneMap.containsKey(node)){
            return cloneMap.get(node);
        }
        
        Node cloneNode = new Node(node.val);
        cloneMap.put(node, cloneNode);// its important to add to hashmap here
        for(Node neighbor : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}