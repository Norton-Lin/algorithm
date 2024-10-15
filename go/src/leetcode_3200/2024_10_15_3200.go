package main

/*
 * @lc app=leetcode.cn id=3200 lang=golang
 *
 * [3200] 三角形的最大高度
 */

// @lc code=start
// 奇数行平方递增 ai = i^2
// 偶数行 2 4 6 8 10 (n+1)*n
func MaxHeightOfTriangle(red int, blue int) int {
	cnt := [2]int{}
	for i := 1; ; i++ {
		cnt[i%2] += i
		//超限制
		if (cnt[0] > red || cnt[1] > blue) && (cnt[0] > blue || cnt[1] > red) {
			return i - 1
		}
	}
}

// @lc code=end
