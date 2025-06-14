package contest453

// j可解锁i，j<i && complexity[j] < complexity[i]©leetcode
// 初始0，complexity[0]解锁
// 无解： complexity[0]不是最小值
func CountPermutations(complexity []int) int {
	mod := 1_000_000_000 + 7
	ans := 1
	n := len(complexity)
	for i := 1; i < n; i++ {
		if complexity[i] <= complexity[0] {
			ans = 0
			break
		}
		ans = ans * (n - i) % mod
	}
	return ans
}
