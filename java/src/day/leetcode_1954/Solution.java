/*
 * @lc app=leetcode.cn id=1954 lang=java
 *
 * [1954] 收集足够苹果的最小花园周长
 */
package day.leetcode_1954;
// @lc code=start
class Solution {
    //买下土地是正方形
    //边长是八的倍数
    public long minimumPerimeter(long neededApples) {
        long cur = 0;
        long len = 0;
        while(cur < neededApples){
            ++len;
            cur=2L*(2L*len+1)*len*(len+1); 
        }
        return len*8;
    }
}
// @lc code=end

