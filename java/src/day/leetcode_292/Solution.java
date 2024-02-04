package day.leetcode_292;
/*
 * @lc app=leetcode.cn id=292 lang=java
 *
 * [292] Nim 游戏
 */

// @lc code=start
class Solution {
    //尼姆博弈
    //保证自己能够拿到最后一块石头
    //两个人每次拿一到三块
    //每一轮对局可以控制共拿四块石头
    //先手转后手
    public boolean canWinNim(int n) {
        return n%4!=0;
        //return n&3!=0;
    }
}
// @lc code=end

