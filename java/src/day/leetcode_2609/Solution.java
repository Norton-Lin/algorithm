/*
 * @lc app=leetcode.cn id=2609 lang=java
 *
 * [2609] 最长平衡子字符串
 */
package day.leetcode_2609;
// @lc code=start
class Solution {
    //0都在1之前 且 01数量相同
    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0;
        int left  = 0;
        int right = 0;
        int cur = 0;
        boolean tag = true;
        while(cur<s.length()){
            if(s.charAt(cur) == '0'){
                if(tag){
                    ans = Math.max(ans,Math.min(right-left,cur-right)*2);
                    left = cur;
                    tag = false;
                }
            }
            else{
                if(!tag){
                    right = cur;
                    tag = true;
                }
            }
            ++cur;
        }
        ans = Math.max(ans,Math.min(right-left,cur-right)*2);
        return ans;
    }
}
// @lc code=end

