package main

import "sort"

/*
 * @lc app=leetcode.cn id=2597 lang=golang
 *
 * [2597] 美丽子集的数目
 */

// @lc code=start
// 长度为1 必定为美丽子集
// 任意两个绝对值差不为k
// dp 以i为结尾，i > j 如果i-j != k,i结尾的可能组合就可以加上j结尾的
// 但是如果j结尾的组合里包含了一些x,i-x = k呢
// 每个都要记录包含的类型，如果包含上述x，要去掉,x只会出现一次
func beautifulSubsets(nums []int, k int) int {
	groups := make(map[int]map[int]int)
	for _, a := range nums {
		mod := a % k
		if _, ok := groups[mod]; !ok {
			groups[mod] = make(map[int]int)
		}
		groups[mod][a]++ //模，原值
	}
	ans := 1
	for _, g := range groups {
		keys := make([]int, 0, len(g)) //g表示同模数有多少
		for key := range g {
			keys = append(keys, key)
		}
		sort.Ints(keys)
		m := len(keys)
		f := make([][2]int, m)
		f[0][0] = 1
		f[0][1] = (1 << g[keys[0]]) - 1
		for i := 1; i < m; i++ {
			f[i][0] = f[i-1][0] + f[i-1][1]
			if keys[i]-keys[i-1] == k {
				f[i][1] = f[i-1][0] * ((1 << g[keys[i]]) - 1)
			} else {
				f[i][1] = (f[i-1][0] + f[i-1][1]) * ((1 << g[keys[i]]) - 1)
			}
		}
		ans *= f[m-1][0] + f[m-1][1]
	}
	return ans - 1
}

// @lc code=end
