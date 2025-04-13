package main

/*
 * @lc app=leetcode.cn id=1922 lang=golang
 *
 * [1922] 统计好数字的数目
 */

// @lc code=start
func CountGoodNumbers(n int64) int {
	mod := int64(1000000000 + 7)
	base := make([]int64, 0)
	tmp := n
	base = append(base, int64(5))
	base = append(base, int64(20))
	tmp >>= 2
	count := 0
	pre := int64(20)
	ans := int64(1)
	for ; tmp > 0; tmp >>= 1 {
		pre *= pre
		pre %= mod
		base = append(base, pre)
	}
	for ; n > 0; n >>= 1 {
		if n&1 == 1 {
			ans *= base[count]
			ans %= mod
		}
		count++
	}
	// ans*=int64(4)
	// ans = ans % mod
	return int(ans)
}

// @lc code=end
