package day.leetcode_2678;
/*
 * @lc app=leetcode.cn id=2678 lang=java
 *
 * [2678] 老人的数目
 */

// @lc code=start
class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for(String s:details)
            if(Integer.parseInt(s.substring(s.length()-4, s.length()-2))>60)
                ++ans;
        return ans;
    }
}
// @lc code=end

