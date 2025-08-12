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
    public Node cloneGraph(Node node) {
        if(node==null)
            return node; 
        HashMap<Node,Node> graphMap = new HashMap<>();
        return cloneUtil(node,graphMap);
    }
    private Node cloneUtil(Node node,HashMap<Node,Node>graphMap){

        Node newNode = new Node(node.val);
        graphMap.put(node,newNode);

        for(Node neigh : node.neighbors){
            if(graphMap.containsKey(neigh)){
                 newNode.neighbors.add(graphMap.get(neigh));
            }
            else
            newNode.neighbors.add(cloneUtil(neigh,graphMap));
        }
      return newNode;
    }
}