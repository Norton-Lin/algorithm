package main

/*
 * @lc app=leetcode.cn id=2360 lang=golang
 *
 * [2360] 图中的最长环
 */

// @lc code=start
// 遍历标记，保证尽可能少重复
func LongestCycle(edges []int) int {
	ans := -1
	n := len(edges)
	flags := make([]bool, n)
	records := make(map[int]int)
	i := 0
	count := 0
	index := 0
	for i < n {
		if i == -1 {
			records = make(map[int]int)
			count = 0
			for i = index + 1; i < n && flags[i]; i++ {
				index++
			}
		} else if value, ok := records[i]; ok {
			ans = max(ans, len(records)-value)
			records = make(map[int]int)
			count = 0
			for i = index + 1; i < n && flags[i]; i++ {
				index++
			}
		} else {
			if !flags[i] {
				if i == index+1 {
					index++
				}
				flags[i] = true
				records[i] = count
				i = edges[i]
				count++
			} else {
				records = make(map[int]int)
				count = 0
				for i = index + 1; i < n && flags[i]; i++ {
					index++
				}
			}

		}
	}
	return ans
}

// @lc code=end
