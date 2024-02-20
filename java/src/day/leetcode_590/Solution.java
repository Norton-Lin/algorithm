/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N 叉树的后序遍历
 */

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
// @lc code=start


class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        dfs(root);
        return ans;
    }
    public void dfs(Node root){
        if(root == null)
            return;
        for(Node cur: root.children)
            dfs(cur);
        ans.add(root.val);
    }
}
// @lc code=end

