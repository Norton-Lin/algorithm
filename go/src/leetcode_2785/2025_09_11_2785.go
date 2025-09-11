package main

/*
 * @lc app=leetcode.cn id=2785 lang=golang
 *
 * [2785] 将字符串中的元音字母排序
 */

// @lc code=start
// 基本方法，排序后把元音填进去
// func SortVowels(s string) string {
// 	set := make(map[string]struct{})
// 	set["a"] = struct{}{}
// 	set["e"] = struct{}{}
// 	set["i"] = struct{}{}
// 	set["o"] = struct{}{}
// 	set["u"] = struct{}{}
// 	set["A"] = struct{}{}
// 	set["E"] = struct{}{}
// 	set["I"] = struct{}{}
// 	set["O"] = struct{}{}
// 	set["U"] = struct{}{}
// 	tmp := make([]rune, len(s))
// 	copy(tmp, []rune(s))
// 	sort.Slice(tmp, func(i, j int) bool {
// 		return tmp[i] < tmp[j]
// 	})
// 	ans := make([]rune, len(s))
// 	copy(ans, []rune(s))
// 	j := 0
// 	for i := 0; i < len(s); i++ {
// 		if _, ok := set[string(ans[i])]; ok {
// 			for ; j < len(s); j++ {
// 				if _, ok := set[string(tmp[j])]; ok {
// 					break
// 				}
// 			}
// 			ans[i] = tmp[j]
// 			j++
// 		}

// 	}
// 	return string(ans)
// }
// 进阶，统计元音数量，然后直接根据元音填充，无需排序
func SortVowels(s string) string {
	records := make([]bool, 'z'-'A'+1)
	count := make([]int, 'z'-'A'+1)
	for _, c := range "aeiouAEIOU" {
		records[c-'A'] = true
	}
	for _, c := range s {
		if !records[c-'A'] {
			continue
		}
		count[c-'A']++
	}
	ans := []byte(s)
	j := 0
	for i := 0; i < len(s); i++ {
		if !records[ans[i]-'A'] {
			continue
		}
		for count[j] == 0 {
			j++
		}
		ans[i] = byte(j) + 'A'
		count[j]--
	}
	return string(ans)
}

// @lc code=end
