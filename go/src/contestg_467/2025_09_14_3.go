package main

// 深搜？

// 深搜？woc尼马还超时
type valCnt struct {
	val int
	cnt int
}

func subsequenceSumAfterCapping(nums []int, k int) []bool {
	n := len(nums)
	ans := make([]bool, n)
	countMap := make(map[int]int)
	maxVal := 0
	for _, num := range nums {
		countMap[num]++
		if num > maxVal {
			maxVal = num
		}
	}
	values := make([]valCnt, 0)
	for val, cnt := range countMap {
		values = append(values, valCnt{val, cnt})
	}
	for x := 1; x <= n; x++ {
		if x > maxVal {
			ans[x-1] = ans[x-2]
			continue
		}
		ans[x-1] = dpSum(values, x, k)
	}
	return ans
}
func dpSum(values []valCnt, x int, target int) bool {
	if target == 0 {
		return true
	}
	//fmt.Println(nums)
	dp := make([]bool, target+1)
	dp[0] = true
	for _, num := range values {
		cur := min(num.val, x)
		for count := 1; count <= num.cnt; count++ {
			for j := target; j >= cur; j-- {
				if dp[j-cur] {
					dp[j] = true
					if j == target {
						return true
					}
				}
			}
		}
	}
	return dp[target]
}
