/*
 * @lc app=leetcode.cn id=2476 lang=java
 *
 * [2476] 二叉搜索树最近节点查询
 */
import java.util.ArrayList;
import java.util.List;
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
    //找 queries对应的min max
    //当 queries在树上找不到min max 用-1代替
    //树可能退化成一个链，导致超时，要转换成数组做二分搜索
    /** 
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i: queries){
            ans.add(search(root,i));
        }
        return ans;
    }
    public List<Integer> search(TreeNode root, int target){
        int min = -1;
        int max = -1;
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null){
            //System.out.println(cur.val);
            if(cur.val<target){
                min = cur.val;
                cur = cur.right;
            }else if(cur.val>target){
                max = cur.val;
                cur = cur.left;
            }else{
                min = max = cur.val;
                break;
            }
        }
        ans.add(min);
        ans.add(max);
        return ans;
    }*/
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<Integer>();
        dfs(root, arr);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int val : queries) {
            int maxVal = -1, minVal = -1;
            int idx = binarySearch(arr, val);
            if (idx != arr.size()) {
                maxVal = arr.get(idx);
                if (arr.get(idx) == val) {
                    minVal = val;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(minVal);
                    list.add(maxVal);
                    res.add(list);
                    continue;
                }
            }
            if (idx > 0) {
                minVal = arr.get(idx - 1);
            }
            List<Integer> list2 = new ArrayList<Integer>();
            list2.add(minVal);
            list2.add(maxVal);
            res.add(list2);
        }
        return res;
    }

    public void dfs(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }    
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
    }

    public int binarySearch(List<Integer> arr, int target) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
// @lc code=end

