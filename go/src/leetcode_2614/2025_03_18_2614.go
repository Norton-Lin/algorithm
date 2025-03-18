package main

/*
 * @lc app=leetcode.cn id=2614 lang=golang
 *
 * [2614] 对角线上的质数
 */

// @lc code=start
func DiagonalPrime(nums [][]int) int {
	record := check(4000001)
	ans := 0
	n := len(nums)
	for i := 0; i < n; i++ {
		if !record[nums[i][i]] && nums[i][i] > ans {
			ans = nums[i][i]
		}
		if !record[nums[i][n-1-i]] && nums[i][n-1-i] > ans {
			ans = nums[i][n-1-i]
		}
	}
	if ans < 2 {
		ans = 0
	}
	return ans
}
func check(n int) []bool {
	res := make([]bool, n)
	record := make([]int, n)
	res[0] = true
	res[1] = true
	count := 0
	for i := 2; i < n; i++ {
		if !res[i] {
			record[count] = i
			count++
		}
		for j := 0; j < count && i*record[j] < n; j++ {
			res[i*record[j]] = true
			if i%record[j] == 0 {
				break
			}
		}
	}

	return res
}

// @lc code=end
