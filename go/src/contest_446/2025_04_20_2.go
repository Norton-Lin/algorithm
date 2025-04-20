package contest446

// 每次替换，把子数组换成当中的最小值
// 就是找到第一个非递减，前面的数删去
func MaximumPossibleSize(nums []int) int {
	pre := nums[0]
	n := len(nums)
	ans := len(nums)
	for i := 1; i < n; i++ {
		cur := nums[i]
		if cur < pre {
			// 找到第一个非递减数
			j := i
			//fmt.Println(ans,i,j)
			for ; j < n && cur < pre; j++ {
				cur = nums[j]
			}
			j--
			if nums[j] < pre {
				j++
			}
			//fmt.Println(ans,i,j)
			ans = ans - (j - i)
			i = j
			//fmt.Println(ans,i)
		}
		if i < n {
			pre = nums[i]
		}
	}
	return ans
}
