package hot100.leetcode_128;
/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

import java.util.HashSet;
import java.util.Set;
// @lc code=start
class Solution {
    //数据范围 -10^9 - 10^9
    //时间复杂度O(n) 不可排序
    //哈希表，记录序列头尾，新数字根序列相邻，就合并
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums)
            set.add(i);
        for(int i: set){
            if(!set.contains(i-1)){
                int cur = i;
                int len = 1;
                //哈希寻找 O(n)
                while(set.contains(cur+1)){
                    ++len;
                    ++cur;
                }
                ans = Math.max(ans,len);
            }
        }
        return ans;
    }
}
// @lc code=end

