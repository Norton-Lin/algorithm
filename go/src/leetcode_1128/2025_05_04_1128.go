package main

/*
 * @lc app=leetcode.cn id=1128 lang=golang
 *
 * [1128] 等价多米诺骨牌对的数量
 */

// @lc code=start
// 规模小可以考虑直接矩阵记录等价数对数
// 这里用的是逐个统计 最差O(n^2)
func NumEquivDominoPairs(dominoes [][]int) int {
	ans := 0
	n := len(dominoes)
	records := make([]bool, n)
	cur := make([]int, 2)
	value := 0
	for i := 0; i < n; i++ {
		if records[i] {
			continue
		}
		records[i] = true
		value = 1
		cur[0], cur[1] = dominoes[i][0], dominoes[i][1]
		for j := i + 1; j < n; j++ {
			if !records[j] && ((dominoes[j][0] == cur[0] && dominoes[j][1] == cur[1]) || (dominoes[j][0] == cur[1] && dominoes[j][1] == cur[0])) {
				value++
				records[j] = true
			}
		}
		ans += ((value - 1) * value) / 2
	}
	return ans
}

// @lc code=end
