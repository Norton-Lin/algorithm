/*
 * @lc app=leetcode.cn id=2048 lang=java
 *
 * [2048] 下一个更大的数值平衡数
 */
package leetcode_2048;
// @lc code=start
class Solution {
    public int nextBeautifulNumber(int n) {
        //1224444是最大的平衡数
        for (int i = n + 1; i <= 1224444; ++i) {
            if (isBalance(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isBalance(int x) {
        int[] count = new int[10];
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }
        for (int d = 0; d < 10; ++d) {
            if (count[d] > 0 && count[d] != d) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
