/*
 * @lc app=leetcode.cn id=2828 lang=java
 *
 * [2828] 判别首字母缩略词
 */

// @lc code=start
package day.leetcode_2828;

import java.util.List;

class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if(words.size()!=s.length())
            return false;
        int index = 0;
        for(String word: words)
            if(word.charAt(0)!=s.charAt(index++))
                return false;
        return true;
    }
}
// @lc code=end

