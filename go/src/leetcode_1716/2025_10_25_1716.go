package main

/*
 * @lc app=leetcode.cn id=1716 lang=golang
 *
 * [1716] 计算力扣银行的钱
 */

// @lc code=start
func TotalMoney(n int) int {
	ans := 0
	pre := 0
	cnt := 0
	cur := 0
	for cnt < n {
		if cnt%7 == 0 {
			pre++
			cur = pre
		}
		ans += cur
		cur++
		cnt++
	}
	return ans
}

// @lc code=end
