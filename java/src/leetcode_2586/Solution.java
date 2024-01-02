/*
 * @lc app=leetcode.cn id=2586 lang=java
 *
 * [2586] 统计范围内的元音字符串数
 */
package leetcode_2586;
// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character>set = new HashSet<>();
        int ans = 0;
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        while(left<=right){
            if(set.contains(words[left].charAt(0))&&set.contains(words[left].charAt(words[left].length()-1)))
                ++ans;
            ++left;
        }
        return ans;
    }
}
// @lc code=end

