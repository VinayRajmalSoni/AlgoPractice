class DSU {
    int[] Parent, Size;
    int comps;

    public DSU(int n) {
        comps = n;
        Parent = new int[n + 1];
        Size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            Parent[i] = i;
            Size[i] = 1;
        }
    }

    public int find(int node) {
        if (Parent[node] != node) {
            Parent[node] = find(Parent[node]);
        }
        return Parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;
        if (Size[pu] < Size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        comps--;
        Size[pu] += Size[pv];
        Parent[pv] = pu;
        return true;
    }

    public int components() {
        return comps;
    }
}

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return false;
            }
        }
        return dsu.components() == 1;
    }
}

/*
Using DFS for cycle detection
*/
class Solution2 {
    // for graph to be tree
    // it should have one connected component
    // there should not be any cycles
    // Space complexity (adj_map)O(n+m) + (visited)O(n) + (recursion) O(n)(degree of vertex)
    // Hence space complexity is O(n+m)
    // Time complexity O(n+m)
    // Check this before: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
    // for tree, there should be only one connected component and no cycle
    public boolean validTree(int n, int[][] edges) {
        // Your code goes here
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i< n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);            
        }
        // check if there is a cycle in the graph
        HashSet<Integer> visited = new HashSet<>();
        int startNode = 0;
        if(hasCycle(graph, startNode, visited, -1)) {
            return false;
        }
        // check if the whole graph is connected
        // this is when you visit all nodes from root node
        // all of them should be visited
        if(edges.length != n-1) {
            return false;
        }
        for(int node: graph.keySet()) {
            if(!visited.contains(node)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCycle(HashMap<Integer, List<Integer>> graph, int node, HashSet<Integer> visited, int parent) {
        visited.add(node);
        for(int neighbor: graph.get(node)) {
            if(visited.contains(neighbor) && neighbor != parent) {
                return true;
            }
            else if(!visited.contains(neighbor)) {
                if(hasCycle(graph, neighbor, visited, node)){
                    return true;
                }
            }
        }
        return false;
    }
    
    /*
    logic for detecting cycle
    0->[1,2,3]
    1->[0,4]
    2->[0]
    3->[0]
    4->[1]

    The core logic to detect a cycle:
    An edge from a node should either go to the parent or to a non visited neighbor, if an edge goes to a visited neighbor which is not a parent then there is a cycle.
     */
    public boolean dfs(HashSet<Integer>[] adj_map, int node, int[] visited, int component_count, int[] parent){
        visited[node] = component_count;
        for(int neighbor : adj_map[node]){
            // neighbour is a non visited node
            if(visited[neighbor] == 0){
                parent[neighbor] = node;
                if(!dfs(adj_map, neighbor, visited, component_count, parent))
                    return false;
            }
            // or neighbour should be a parent, if ot there is a cycle
            else if(parent[node] != neighbor){
                return false; // backedge
            }
        } 
        return true;
    }
    
    public boolean bfs(HashSet<Integer>[] adj_map, int node, int[] visited, int component_count, int[] parent){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = component_count;
        while(!queue.isEmpty()){
            int n = queue.poll();
            for(int neighbor: adj_map[n]){
                if(visited[neighbor] == 0){
                    visited[neighbor] = component_count;
                    parent[neighbor] = n;
                    queue.add(neighbor);
                }
                else if(parent[n] != neighbor){
                    return false; // cross edge
                }
            }            
        }
        return true;
    }
}