/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start

// Definition for a Node.
package leetcode_117;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};




class Solution {
    //层序遍历 
    /**
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        Node cur ;
        if(root == null)
            return null;
        queue.add(root);
        int count = queue.size();
        while(!queue.isEmpty()){
            --count;
            cur = queue.poll();
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
            if(count>0){
                cur.next = queue.peek();
            }
            else{
                count = queue.size();
            }
        }
        return root;
    } */
    //利用next，一次遍历O(n)
    public Node connect(Node root){
        Node cur = root;
        while(cur!=null){
            Node temp = new Node();
            Node pre = temp;
            while (cur!=null) {
                if(cur.left!=null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right!=null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = temp.next;
        }
        return root;
    }


}
// @lc code=end

