package main

/*
 * @lc app=leetcode.cn id=2929 lang=golang
 *
 * [2929] 给小朋友们分糖果 II
 */

// @lc code=start
func DistributeCandies(n int, limit int) int64 {
	ans := int64(0)
	for i := 0; i <= min(n, limit); i++ {
		//非法配置
		if n-i > 2*limit {
			continue
		}
		ans += int64(min(n-i, limit) - max(n-limit-i, 0) + 1)
	}
	return ans
}

// @lc code=end
