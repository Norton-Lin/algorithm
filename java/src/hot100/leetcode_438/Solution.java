package hot100.leetcode_438;
/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// @lc code=start
class Solution {
    //统计字母出现次数
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        //p串不一定比s串小
        if(p.length()>s.length())
            return ans;
        int target[] = new int[26];
        int cur[] = new int[26];
        int start = p.length();
        for(int i = 0;i<p.length();++i){
            ++target[p.charAt(i)-'a'];
            ++cur[s.charAt(i)-'a'];
        }
        int j = 0;
        while(j<26){
            if(target[j]!=cur[j])
                break;
            ++j;
        }
        if(j==26)
            ans.add(0);
        for(int i = start;i<s.length();++i){
            --cur[s.charAt(i-start)-'a'];
            ++cur[s.charAt(i)-'a'];
            j = 0;
            while(j<26){
                if(target[j]!=cur[j])
                    break;
                ++j;
            }
            if(j==26)
                ans.add(i-start+1);
        }
        return ans;
    }
}
// @lc code=end

