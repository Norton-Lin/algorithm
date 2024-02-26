package day.leetcode_235;
/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
// @lc code=start
class Solution {
    //先找其中一个结点，再找另一个结点
    //祖先结点哈希记录，同时记录深度
    /** 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, Integer> map1 = new HashMap<>();
        Map<TreeNode, Integer> map2 = new HashMap<>();
        map1.put(root, 0);
        map2.put(root, 0);
        dfs(root, p, 1, map1);
        dfs(root, q, 1, map2);
        TreeNode ans = root;
        int depth = 0;
        for(TreeNode key : map1.keySet()){
            if(map2.containsKey(key)){
                if(map2.get(key)>depth){
                    ans = key;
                    depth = map2.get(key);
                }
            }
        }
        return ans;
    }
    public boolean dfs(TreeNode root, TreeNode target, int depth,Map<TreeNode, Integer> map){
        if(root == null)
            return false;
        if(root == target){
            map.put(root, depth);
            return true;
        }
        boolean left = dfs(root.left, target, depth + 1, map);
        if(left){
            map.put(root, depth);
            return true;
        }
        boolean right = dfs(root.right, target , depth + 1, map);
        if(right){
            map.put(root, depth);
            return true;
        }
        return false;
    }*/
    //这是个二叉搜索树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        TreeNode ans = null;
        while(true){
            //root值过大，找小
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            } else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else {
                ans = root;
                break;
            }
                
        }
        return ans;
    }
}
// @lc code=end

