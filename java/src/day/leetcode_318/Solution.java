package day.leetcode_318;
/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */
// @lc code=start
class Solution {
    //单词不含公共字母
    public int maxProduct(String[] words) {
        int ans = 0;
        boolean[][] record = new boolean[words.length][26];
        for(int i = 0;i<words.length;++i){
            for(char c:words[i].toCharArray()){
                record[i][c-'a'] = true;
            }
        }
        for(int i = 0;i<words.length;++i){
            for(int j = i+1;j<words.length;++j){
                if(check(record[i], record[j]))
                    ans = Math.max(ans,words[i].length()*words[j].length());
            }
        }
        return ans;
    }
    public boolean check(boolean[] record1,boolean[] record2){
        for(int i = 0;i<26;++i){
            if(record1[i]&record2[i])
                return false;
        }
        return true;
    }
}
// @lc code=end

