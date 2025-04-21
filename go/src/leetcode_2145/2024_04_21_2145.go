package main

/*
 * @lc app=leetcode.cn id=2145 lang=golang
 *
 * [2145] 统计隐藏数组数目
 */

// @lc code=start
func NumberOfArrays(differences []int, lower int, upper int) int {
	mini, maxi := int64(0), int64(0)
	diff := int64(upper - lower)
	cur := int64(0)
	ans := int64(0)
	for _, num := range differences {
		cur += int64(num)
		if cur < mini {
			mini = cur
		}
		if cur > maxi {
			maxi = cur
		}
	}
	ans = diff - (maxi - mini) + 1
	if ans < 0 {
		ans = 0
	}
	return int(ans)
}

// @lc code=end
