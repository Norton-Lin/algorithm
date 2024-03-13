package day.leetcode_2864;
/*
 * @lc app=leetcode.cn id=2864 lang=java
 *
 * [2864] 最大二进制奇数
 */

// @lc code=start
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int num = 0;
        StringBuilder ans = new StringBuilder();
        for(char c:s.toCharArray())
            if(c == '1')
                ++num;
        for(int i = 0;i<num-1;++i){
            ans.append('1');
        }
        for(int i = 0;i<s.length()-num;++i)
            ans.append('0');
        return ans.toString()+"1";

    }
}
// @lc code=end

