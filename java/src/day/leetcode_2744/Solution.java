package day.leetcode_2744;
/*
 * @lc app=leetcode.cn id=2744 lang=java
 *
 * [2744] 最大字符串配对数目
 */
import java.util.HashSet;
import java.util.Set;
// @lc code=start
class Solution {
    //哈希匹配
    /**
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>();
        int count = 0;
        for(String word: words){
            set.add(word);
        }
        for(String word: words){
            String cur = word.substring(1)+word.substring(0,1);
            if(cur.equals(word))
                continue;
            if(set.contains(cur)){
                ++count;
                set.remove(word);
                set.remove(cur);
            }
                
        }
        return count;
    } */
    //哈希匹配优化
    /** 
    public int maximumNumberOfStringPairs(String[] words){
        Set<String> set = new HashSet<>();
        int count = 0;
        for(String word: words){
            if(set.contains(word)){
                ++count;
                set.remove(word);
            }
            else
                set.add(word.substring(1)+word.substring(0,1));
        }
        return count;
    }*/
    //暴力双循环
    public int maximumNumberOfStringPairs(String[] words){
        int count = 0;
        for(int i = 0;i<words.length;++i){
            for(int j = i+1;j<words.length;++j){
                if(words[i].charAt(0) == words[j].charAt(1)&&words[j].charAt(0) == words[i].charAt(1)){
                    ++count;
                    break;
                }
            }
        }
        return count;
    }
    
}
// @lc code=end

