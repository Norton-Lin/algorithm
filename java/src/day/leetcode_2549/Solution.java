package day.leetcode_2549;
/*
 * @lc app=leetcode.cn id=2549 lang=java
 *
 * [2549] 统计桌面上的不同数字
 */

// @lc code=start
class Solution {
    //一开始n在桌面上
    //找n%i == 1的 随后n变成 符合n%i == 1
    //1特殊处理
    public int distinctIntegers(int n) {
        return n==1?1:n-1;
    }
}
// @lc code=end

