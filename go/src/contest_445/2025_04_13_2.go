package contest445

// 获取最小回文
// 小字符往前
func SmallestPalindrome1(s string) string {
	n := len(s)
	target := make([]rune, n)
	records := make([]int, 26)
	index := 0
	for _, c := range s {
		records[c-'a'] += 1
	}
	for i := 0; i < 26; i++ {
		for ; records[i] > 0; records[i] -= 2 {
			if records[i] == 1 {
				target[n/2] = rune('a' + i)
				break
			}
			target[index] = rune('a' + i)
			target[n-index-1] = rune('a' + i)
			index++
		}
	}
	return string(target)
}
