package main

/*
 * @lc app=leetcode.cn id=135 lang=golang
 *
 * [135] 分发糖果
 */
// ratings[i] > ratings[i-1] i的糖果比i-1多一个
// 否则少
// @lc code=start
func Candy(ratings []int) int {
	ans := 0
	n := len(ratings)
	left := make([]int, n)
	left[0] = 1
	pre := ratings[0]
	cur := 1
	for i := 1; i < n; i++ {
		if ratings[i] > pre {
			left[i] = left[i-1] + 1
		} else {
			left[i] = 1
		}
		pre = ratings[i]
	}
	ans += max(left[n-1], cur)
	for i := n - 2; i >= 0; i-- {
		if ratings[i] > pre {
			cur++
		} else {
			cur = 1
		}
		pre = ratings[i]
		ans += max(left[i], cur)
	}
	return ans
}

// @lc code=end
