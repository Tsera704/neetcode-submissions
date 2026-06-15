/*
Definition for a Node.
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
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> sets = new HashMap<>();
        return dfs( node, sets);
    }
    public Node dfs( Node root, HashMap<Node, Node> sets){
        if(root == null ) return null;

        if( sets.containsKey(root)){
            return sets.get(root);
        }

        Node copy = new Node( root.val);
        sets.put( root, copy);
        for( Node nei : root.neighbors){
            copy.neighbors.add( dfs(nei, sets));
        }
        return copy;
    }
}