/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    //kmp next数组
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> record = new HashSet<>();
        String cur;
        for(int i =0;i<=s.length()-10;++i)
        {
            cur = s.substring(i, i+10);
            if(set.contains(cur))
                record.add(cur);
            set.add(cur);
        }
        return new ArrayList<>(record);
    }
}
// @lc code=end

