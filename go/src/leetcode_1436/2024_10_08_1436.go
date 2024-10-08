package main

/*
 * @lc app=leetcode.cn id=1436 lang=golang
 *
 * [1436] 旅行终点站
 */

// @lc code=start
func DestCity(paths [][]string) string {
	ans := ""
	record := make(map[string]bool, len(paths)) //限制空间，更快
	for _, path := range paths {
		record[path[0]] = true
	}
	for _, path := range paths {
		// if !record[path[1]]
		if _, ok := record[path[1]]; !ok { //更快
			ans = path[1]
			break
		}
	}
	return ans
}

// @lc code=end
