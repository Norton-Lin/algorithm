package main

import (
	"sort"
)

/*
 * @lc app=leetcode.cn id=2234 lang=golang
 *
 * [2234] 花园的最大总美丽值
 */

// @lc code=start
// partial 用一次 full可以用多次
// 如果partial * minFlower > full 使用
// 根据新种植的花，同样情况是选择更多full还是提高partical
// 否则尽量full
// 一轮循环 o（n)
func MaximumBeauty(flowers []int, newFlowers int64, target int, full int, partial int) int64 {
	n := len(flowers)
	for i := 0; i < n; i++ {
		if flowers[i] > target {
			flowers[i] = target
		}
	}
	sort.Sort(sort.Reverse(sort.IntSlice(flowers)))
	var sum int64
	for _, flower := range flowers {
		sum += int64(flower)
	}
	var ans int64
	if int64(target)*int64(n)-sum <= newFlowers {
		ans = int64(full) * int64(n)
	}
	pre, ptr := int64(0), 0
	for i := 0; i < n; i++ {
		if i != 0 {
			pre += int64(flowers[i-1])
		}
		if flowers[i] == target {
			continue
		}
		rest := newFlowers - (int64(target)*int64(i) - pre)
		if rest < 0 {
			break
		}
		for !(ptr >= i && int64(flowers[ptr])*int64(n-ptr)-sum <= rest) {
			sum -= int64(flowers[ptr])
			ptr++
		}
		rest -= int64(flowers[ptr])*int64(n-ptr) - sum
		ans = max(ans, int64(full)*int64(i)+int64(partial)*min(int64(flowers[ptr])+rest/int64(n-ptr), int64(target)-1))
	}

	return ans
}

// @lc code=end
