package main

/*
 * @lc app=leetcode.cn id=3158 lang=golang
 *
 * [3158] 求出出现两次数字的 XOR 值
 */

// @lc code=start
// 数组优化哈希
func DuplicateNumbersXOR(nums []int) int {
	ans := 0
	//record := make(map[int]int, len(nums))
	record := make([]int, 51)
	for _, i := range nums {
		record[i]++
	}
	for i, j := range record {
		if j == 2 {
			ans ^= i
		}
	}
	return ans
}

// @lc code=end
