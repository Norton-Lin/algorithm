package main

/*
 * @lc app=leetcode.cn id=2610 lang=golang
 *
 * [2610] 转换二维数组
 */

// @lc code=start
func FindMatrix(nums []int) [][]int {
	ans := make([][]int, 0)
	count := len(nums)
	records := make(map[int]int)
	for _, num := range nums {
		records[num]++
	}
	for count > 0 {
		cur := make([]int, 0)
		for key, value := range records {
			if value > 0 {
				count--
				records[key]--
				cur = append(cur, key)
			}
		}
		ans = append(ans, cur)
	}
	return ans
}

// @lc code=end
