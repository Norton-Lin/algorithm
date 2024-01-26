package hot100.leetcode_3;
/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

import java.util.HashSet;
import java.util.Set;
// @lc code=start

class Solution {
    //如果一个字符串是不重复的，那么，尾部加入一个新字符，要么长度＋1，要么滑动窗口
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int cur = 0;
        for(int i = 0;i<s.length();++i){
            char c = s.charAt(i);
            //子串重复，滑动
            if(set.contains(c)){
                for(int j = i-cur;j<i;++j){
                    char ch = s.charAt(j);
                    if(set.contains(ch))
                        set.remove(ch);
                    if(ch == c)
                        break;
                }
            }
            set.add(c);
            cur = set.size();
            ans = Math.max(cur,ans);
        }
        return ans;
    }
}
// @lc code=end

