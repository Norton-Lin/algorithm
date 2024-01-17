/*
 * @lc app=leetcode.cn id=466 lang=java
 *
 * [466] 统计重复个数
 */
package day.leetcode_466;
// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    // str1由s1*n1构成
    // str2有s2*n2构成
    // 求 str2*m可以从str1中获取
    // 首先可知 str1.length>= str2.length
    // 求str2 可从几个s1中构成
    // 特殊情况 aaaa*3 = aaa*4
    // 判断多少个s1 可以产生足量str2
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0)
            return 0;
        int count1 = 0, count2 = 0, index = 0;
        // 若遍历了count1个s1,找到了第 s2cnt 个 s2 中的第 index 个字符
        // 如果之前遍历了 count1' 个 s1 时，
        // 匹配到的是第 count2 个 s2 中同样的第 index 个字符，那么就有循环节
        // 说明 （count1,count2 index) 和 （count1',count2',index)包含相同index的匹配
        // - 前 s1cnt' 个 s1 包含了 s2cnt' 个 s2
        // - 以后的每 (s1cnt - s1cnt') 个 s1 包含了 (s2cnt - s2cnt') 个 s2
        // 那么还会剩下 (n1 - s1cnt') % (s1cnt - s1cnt') 个 s1, 我们对这些与 s2 进行暴力匹配
        Map<Integer, int[]> recall = new HashMap<Integer, int[]>();
        int[] preLoop = new int[2];
        int[] curLoop = new int[2];
        while (true) {
            ++count1;
            for (int i = 0; i < s1.length(); ++i) {
                char c = s1.charAt(i);
                if (c == s2.charAt(index)) {
                    ++index;
                    if (index == s2.length()) {
                        index = 0;
                        ++count2;
                    }

                }
            }
            if (count1 == n1) {
                return count2 / n2;
            }
            if (recall.containsKey(index)) {
                int[] value = recall.get(index);
                int count1Prime = value[0];
                int count2Prime = value[1];
                preLoop = new int[] { count1Prime, count2Prime };
                curLoop = new int[] { count1 - count1Prime, count2 - count2Prime };
                break;
            } else {
                recall.put(index, new int[] { count1, count2 });
            }
        }
        int ans = preLoop[1] + (n1 - preLoop[0]) / curLoop[0] * curLoop[1];
        int rest = (n1 - preLoop[0]) % curLoop[0];
        for (int i = 0; i < rest; ++i) {
            for (int j = 0; j < s1.length(); ++j) {
                char c = s1.charAt(j);
                if (c == s2.charAt(index)) {
                    ++index;
                    if (index == s2.length()) {
                        index = 0;
                        ++ans;
                    }

                }
            }

        }
        return ans / n2;

    }
}
// @lc code=end
