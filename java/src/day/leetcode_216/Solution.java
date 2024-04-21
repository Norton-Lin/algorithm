package day.leetcode_216;
/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

import java.util.ArrayList;
import java.util.List;
// @lc code=start

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n,new ArrayList<>(), 1,k);
        return ans;
    }

    public void dfs(int n, List<Integer> cur, int num,int k) {
        if(k==0){
            if(n==0){
                ans.add(new ArrayList<>(cur));
            }
            return ;
        }
        if(num >= n)
            return ;
        for(int i = num+1;i<=9&&i<=n;++i){
            cur.add(i);
            dfs(n-i,cur,i,k-1);
            cur.remove(cur.size()-1);
        }
    }
}
// @lc code=end
