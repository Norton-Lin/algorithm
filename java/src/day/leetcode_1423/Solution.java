/*
 * @lc app=leetcode.cn id=1423 lang=java
 *
 * [1423] 可获得的最大点数
 */
package day.leetcode_1423;
// @lc code=start
class Solution {
    //拿k张牌，可以从头尾交替拿，不可从中间抽取
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0;
        int cur = 0;
        for(int i = 0;i<k;++i){
            ans+=cardPoints[i];
        }
        cur = ans;
        for(int i = 0;i<k;++i){
            cur = cur - cardPoints[k-1-i] + cardPoints[cardPoints.length-1-i];
            ans = Math.max(ans,cur);
        }
        return ans;
    }
}
// @lc code=end

