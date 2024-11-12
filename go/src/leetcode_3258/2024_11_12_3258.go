package main

/*
 * @lc app=leetcode.cn id=3258 lang=golang
 *
 * [3258] 统计满足 K 约束的子字符串数量 I
 */

// @lc code=start
// 二进制串 非0即1
// 满足一个即可
// 大于2k的情况下才有可能不符合
func CountKConstraintSubstrings(s string, k int) int {
	// str := []rune(s)
	// n := len(s)
	// ans, num := (n+1)*n/2, 0
	// values := make([]int, n+1)
	// for index, value := range str{
	// 	if value == '0'{
	// 		num++
	// 	}
	// 	values[index+1] = num
	// }
	// for i := n;i>=2*k;i--{
	// 	for j:=n;j>=i;j--{
	// 		if values[j] - values[j-i] > k && i - values[j]+values[j-i]>k{
	// 			ans--
	// 		}
	// 	}

	// }
	// return ans
	cnt := [2]int{}
	left, ans := 0, 0
	for i, c := range s {
		cnt[c&1]++
		// 左指针移动
		for cnt[0] > k && cnt[1] > k {
			cnt[s[left]&1]--
			left++
		}
		ans += i - left + 1
	}
	return ans
}

// @lc code=end
