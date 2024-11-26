package main

/*
 * @lc app=leetcode.cn id=3238 lang=golang
 *
 * [3238] 求出胜利玩家的数目
 */

// @lc code=start
func WinningPlayerCount(n int, pick [][]int) int {
	records := make([][]int, n)
	ans := 0
	for i := 0; i < n; i++ {
		records[i] = make([]int, 11)
	}
	for _, nums := range pick {
		records[nums[0]][nums[1]]++
	}
	for i, record := range records {
		for _, value := range record {
			if value > i {
				ans++
				break
			}
		}

	}
	return ans
}

// @lc code=end
