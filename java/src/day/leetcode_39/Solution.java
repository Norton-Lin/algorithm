package day.leetcode_39;
/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(new ArrayList<>(),candidates,0,target,0);
        return ans;
    }

    public void dfs(List<Integer> cur,int[] candidates,int index,int target,int sum){
        if(sum>target)
            return ;
        if(sum == target){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = index;i<candidates.length;++i){
            cur.add(candidates[i]);
            dfs(cur,candidates,i,target,sum+candidates[i]);
            cur.remove(cur.size()-1);
        }
    }

}
// @lc code=end
