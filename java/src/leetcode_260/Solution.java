package leetcode_260;
/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans[] = new int[2];
        int count  =0;
        for(int cur:nums)
        {
            if(set.contains(cur))
                set.remove(cur);
            else
                set.add(cur);
        }
        for(Integer cur:set){
            ans[count++] = cur;
        }
        return ans;

    }
}
// @lc code=end

