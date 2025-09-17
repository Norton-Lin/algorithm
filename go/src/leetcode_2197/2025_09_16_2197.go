package main

/*
 * @lc app=leetcode.cn id=2197 lang=golang
 *
 * [2197] 替换数组中的非互质数
 */

// @lc code=start
// 相邻gcd即可，如果当前ans最后一个可以被gcd替换，记得向前看
// 复杂度O(n)，相邻gcd O（n),前向比较最多O(2n)
func ReplaceNonCoprimes(nums []int) []int {
	//stack := make([]int, 0)
	ans := make([]int, 0)
	i := 1
	ans = append(ans, nums[0])
	for ; i < len(nums); i++ {
		index := len(ans) - 1
		cur := gcd(ans[index], nums[i])
		if cur > 1 {
			ans[index] = ans[index] * nums[i] / cur
			//fmt.Println(ans,ans[index], nums[i],cur,index)
			for ; index > 0; index-- {
				cur = gcd(ans[index], ans[index-1])
				if cur > 1 {
					ans[index-1] = ans[index] * ans[index-1] / cur
					ans = ans[0:index]
				} else {
					break
				}
			}
		} else {
			ans = append(ans, nums[i])
		}
		//fmt.Println(ans)
	}
	return ans
}

// 第三个数，每次先和前两个数的gcd比较，新gcd>1,可以合并
func gcd(i, j int) int {
	if j > i {
		i, j = j, i
	}
	for j != 0 {
		i, j = j, i%j
	}
	return i
}

// @lc code=end
