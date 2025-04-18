package main

/*
 * @lc app=leetcode.cn id=2176 lang=golang
 *
 * [2176] 统计数组中相等且可以被整除的数对
 */

// @lc code=start
func CountPairs(nums []int, k int) int {
	records := make(map[int][]int)
	ans := 0
	for i, num := range nums {
		records[num] = append(records[num], i)
	}
	for _, record := range records {
		n := len(record)
		if n < 2 {
			continue
		}
		for i := 0; i < n; i++ {
			for j := i + 1; j < n; j++ {
				if (record[i]*record[j])%k == 0 {
					ans++
				}
			}
		}
	}
	return ans
}

// @lc code=end
