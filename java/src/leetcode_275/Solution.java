package leetcode_275;
/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H 指数 II
 */

// @lc code=start
class Solution {
    // h篇论文，至少被引用h次
    // 要求对数复杂度
    // 二分查找
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length-1;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            if (citations.length - mid == citations[mid])
                return citations[mid];   
            else if (citations.length - mid <= citations[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return citations.length - left ;
    }
}
// @lc code=end
