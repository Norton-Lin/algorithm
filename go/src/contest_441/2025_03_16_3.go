package contest441

// 数据规模，计算可能性
func minZeroArray(nums []int, queries [][]int) int {
	n := len(nums)
	k := len(queries)
	records := make([]int, n)
	ans := -1
	count := make([]map[int]bool, n)
	for i := 0; i < n; i++ {
		count[i] = make(map[int]bool)
		count[i][nums[i]] = true
		for j, query := range queries {
			cur := count[i]
			for key := range cur {
				if key == 0 {
					records[i] = j
					break
				}
				count[i][key] = true
				if i >= query[0] && i <= query[1] {
					if key-query[2] < 0 {
						continue
					}
					count[i][key-query[2]] = true
				}
			}
			if records[i] == j {
				break
			}
		}
	}
	for _, record := range records {
		ans = max(record, ans)
	}
	if ans == k+1 {
		ans = -1
	}
	return ans
}
