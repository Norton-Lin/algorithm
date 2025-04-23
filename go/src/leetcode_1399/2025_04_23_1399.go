package main

/*
 * @lc app=leetcode.cn id=1399 lang=golang
 *
 * [1399] 统计最大组的数目
 */

// @lc code=start
func CountLargestGroup(n int) int {
	records := make([]int, 40)
	maxlen := 0
	ans := 0
	for i := 1; i <= n; i++ {
		cur := i
		index := 0
		for ; cur > 0; cur /= 10 {
			index += cur % 10
		}
		records[index]++
		if maxlen < records[index] {
			maxlen = records[index]
			ans = 1
		} else if maxlen == records[index] {
			ans++
		}
	}
	return ans
}

// @lc code=end
