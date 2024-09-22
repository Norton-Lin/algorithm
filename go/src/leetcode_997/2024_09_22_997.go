package main

/*
 * @lc app=leetcode.cn id=997 lang=golang
 *
 * [997] 找到小镇的法官
 */

// @lc code=start
func FindJudge(n int, trust [][]int) int {
	record := make([]int, n+1)
	self := make([]int, n+1)
	ans := -1
	for _, num := range trust {
		self[num[0]]++
		record[num[1]]++
	}
	for i := 1; i <= n; i++ {
		if record[i] == n-1 && self[i] == 0 {
			if ans == -1 {
				ans = i
			} else {
				return -1
			}

		}
	}
	return ans
}

// @lc code=end
