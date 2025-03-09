package main

/*
 * @lc app=leetcode.cn id=2506 lang=golang
 *
 * [2506] 统计相似字符串对的数目
 */

// @lc code=start
// 字符组成一致的字符串 都相似
// 一组一致的字符可以有 n*(n-1)/2
// 逐个记录
//
//	func similarPairs(words []string) int {
//		n := len(words)
//		ans := 0
//		flags := make([]bool, n)
//		for i := 0; i < n; i++ {
//			flags[i] = false
//		}
//		for index, cur := range words {
//			if flags[index] {
//				continue
//			}
//			flags[index] = true
//			num := 1
//			record := make([]bool, 26)
//			for _, c := range cur {
//				record[c-'a'] = true
//			}
//			//fmt.Println(flags,ans)
//			for k := index + 1; k < n; k++ {
//				if flags[k] {
//					continue
//				}
//				value := make([]bool, 26)
//				for _, c := range words[k] {
//					value[c-'a'] = true
//				}
//				j := 0
//				for j = 0; j < 26; j++ {
//					if record[j] != value[j] {
//						break
//					}
//				}
//				if j == 26 {
//					num++
//					flags[k] = true
//				}
//			}
//			ans += num * (num - 1) / 2
//		}
//		return ans
//	}
//
// 优化
// 位运算
func SimilarPairs(words []string) int {
	ans := 0
	record := make(map[int]int)
	for _, word := range words {
		cur := 0
		for _, c := range word {
			cur |= 1 << (c - 'a') //位记录
		}
		ans += record[cur] //加上目前该字符组合的配对数
		record[cur]++
	}
	return ans
}

// @lc code=end
