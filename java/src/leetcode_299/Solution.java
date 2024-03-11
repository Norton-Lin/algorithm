/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    //统计各个元素数量
    public String getHint(String secret, String guess) {
        int[] record = new int[10];
        int len = secret.length();
        int cnt1 = 0, cnt2 = 0;
        for(int i = 0;i<len;++i){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if(c1 == c2){
                ++cnt1;
            }else{
                ++record[c1-'0'];
            }
        }
        for(int i = 0;i<len;++i){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if(c1 != c2&&record[c1-'0']>0){
                 --record[c1-'0'];
                 ++cnt2;
            }
        }
        return Integer.toString(cnt1)+"A"+Integer.toString(cnt2)+"B";
    }
}
// @lc code=end

