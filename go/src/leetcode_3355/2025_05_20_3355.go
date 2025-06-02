package main

// records 记录起始终止的下标数量
func isZeroArray(nums []int, queries [][]int) bool {
	n := len(nums)
	ans := true
	start, end := make([]int, n), make([]int, n)
	for _, query := range queries {
		start[query[0]]++
		end[query[1]]++
	}
	pre := 0
	for i, num := range nums {
		pre += start[i]
		if i > 0 {
			pre -= end[i-1]
		}
		cur := num - pre
		if cur > 0 {
			ans = false
			break
		}
	}
	return ans
}
