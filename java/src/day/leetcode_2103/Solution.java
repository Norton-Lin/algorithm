package day.leetcode_2103;
/*
 * @lc app=leetcode.cn id=2103 lang=java
 *
 * [2103] 环和杆
 */

// @lc code=start
class Solution {
    //状态压缩 + 位操作
    static final int POLE_NUM = 10;

    public int countPoints(String rings) {
        int[] state = new int[POLE_NUM];
        int n = rings.length();
        for (int i = 0; i < n; i += 2) {
            char color = rings.charAt(i);
            int poleIndex = rings.charAt(i + 1) - '0';
            if (color == 'R') {
                state[poleIndex] |= 1;
            } else if (color == 'G') {
                state[poleIndex] |= 2;
            } else {
                state[poleIndex] |= 4;
            }
        }
        int res = 0;
        for (int i = 0; i < POLE_NUM; i++) {
            res += state[i] == 7 ? 1 : 0;
        }
        return res;
    }
}
// @lc code=end

