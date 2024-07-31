/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Tuple{
    int vlevel;
    int hlevel;
    TreeNode node;
    Tuple(int vlevel,int hlevel,TreeNode node){
        this.vlevel=vlevel;
        this.hlevel=hlevel;
        this.node=node;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple>q=new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> tm = new TreeMap<>();
        q.offer(new Tuple(0,0,root));
        while(!q.isEmpty()){
           Tuple temp= q.poll();
           int v = temp.vlevel;
           int h = temp.hlevel;
           TreeNode curr = temp.node;
           if(!tm.containsKey(v))
           tm.put(v,new TreeMap<>());
           if(!tm.get(v).containsKey(h))
           tm.get(v).put(h,new PriorityQueue<>());

           tm.get(v).get(h).offer(curr.val);

           if(curr.left!=null)
           q.offer(new Tuple(v-1,h+1,curr.left));

           if(curr.right!=null)
           q.offer(new Tuple(v+1,h+1,curr.right));

        }
        List<List<Integer>> ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer> >t: tm.values()){
            ans.add(new ArrayList<>());
            for ( PriorityQueue<Integer> pr : t.values()){
                while(!pr.isEmpty()){
                    ans.get(ans.size()-1).add(pr.poll());
                }
            }
        }
        return ans;
    }
}