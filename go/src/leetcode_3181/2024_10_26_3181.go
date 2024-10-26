package main

import (
	"math/big"
	"slices"
	"sort"
)

/*
 * @lc app=leetcode.cn id=3181 lang=golang
 *
 * [3181] 执行操作可获得的最大总奖励 II
 */

// @lc code=start
func MaxTotalReward(rewardValues []int) int {
	sort.Ints(rewardValues)
	m := slices.Max(rewardValues)
	if slices.Contains(rewardValues, m-1) {
		return 2*m - 1
	}
	_ = slices.Compact(rewardValues)
	one := big.NewInt(1)
	f := big.NewInt(1)
	p := new(big.Int)
	for _, v := range rewardValues {
		mask := p.Sub(p.Lsh(one, uint(v)), one)
		f.Or(f, p.Lsh(p.And(f, mask), uint(v)))
	}
	return f.BitLen() - 1
}

// @lc code=end
