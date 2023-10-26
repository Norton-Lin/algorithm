/*
 * @lc app=leetcode.cn id=2520 lang=java
 *
 * [2520] 统计能整除数字的位数
 */

// @lc code=start
class Solution {
    public int countDigits(int num) {
        int cur = num;
        int mod = 0;
        int ans = 0;
        while(cur>0){
            mod = cur%10;
            cur/=10;
            if(num%mod == 0)
                ++ans;
        }
        return ans;
    }
}
// @lc code=end

