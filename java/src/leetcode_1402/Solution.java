package leetcode_1402;
/*
 * @lc app=leetcode.cn id=1402 lang=java
 *
 * [1402] 做菜顺序
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int ans  = 0;
        int cur = 0;
        int start = satisfaction.length-1;
        Arrays.sort(satisfaction);
        //负数数量
        while(start>=0)
        {
            cur+=satisfaction[start];
            if(cur<0)
            {
                break;
            }
            --start;
        }
        for(int i = 1;i<satisfaction.length-start;++i)
        {
            ans += satisfaction[start+i]*i;
        }
        return ans;
    }
}
// @lc code=end

