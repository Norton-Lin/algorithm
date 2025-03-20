package main

/*
 * @lc app=leetcode.cn id=2612 lang=golang
 *
 * [2612] 最少翻转操作数
 */

// @lc code=start
// 翻转边界问题
func find(f []int, x int) int {
	if f[x] == x {
		return x
	}
	f[x] = find(f, f[x])
	return f[x]
}

func merge(f []int, x, y int) {
	fx := find(f, x)
	fy := find(f, y)
	f[fx] = fy
}

func MinReverseOperations(n, p int, banned []int, k int) []int {
	fa := make([][]int, 2)
	for i := range fa {
		fa[i] = make([]int, n+2)
		for j := range fa[i] {
			fa[i][j] = j
		}
	}
	for _, ban := range banned {
		merge(fa[ban%2], ban, ban+2)
	}
	ans := make([]int, n)
	for i := range ans {
		ans[i] = -1
	}
	q := []int{p}
	ans[p] = 0
	merge(fa[p%2], p, p+2)

	for len(q) > 0 {
		i := q[0]
		q = q[1:]
		mn := max(i-k+1, k-i-1)
		mx := min(i+k-1, n*2-k-i-1)
		fi := 0
		for j := mn; j <= mx; j = fi + 2 {
			fi = find(fa[mn%2], j)
			if fi > mx {
				break
			}
			ans[fi] = ans[i] + 1
			q = append(q, fi)
			merge(fa[mn%2], fi, fi+2)
		}
	}

	return ans
}

// @lc code=end
