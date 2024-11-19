package main

/*
 * @lc app=leetcode.cn id=661 lang=golang
 *
 * [661] 图片平滑器
 */

// @lc code=start
func ImageSmoother(img [][]int) [][]int {
	n := len(img)
	m := len(img[0])
	ans := make([][]int, n)
	for i := 0; i < n; i++ {
		ans[i] = make([]int, m)
	}
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			num := 0
			cur := 0
			for k := max(i-1, 0); k <= min(i+1, n-1); k++ {
				for l := max(j-1, 0); l <= min(j+1, m-1); l++ {
					cur += img[k][l]
					num++
				}
			}
			ans[i][j] = cur / num
		}
	}
	return ans
}

// @lc code=end
