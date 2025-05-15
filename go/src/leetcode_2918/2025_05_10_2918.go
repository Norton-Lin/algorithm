package main

/*
 * @lc app=leetcode.cn id=2918 lang=golang
 *
 * [2918] 数组的最小相等和
 */

// @lc code=start
func MinSum(nums1 []int, nums2 []int) int64 {
	cnt1, cnt2 := 0, 0
	ans := int64(-1)
	sum1, sum2 := int64(0), int64(0)
	for _, num := range nums1 {
		sum1 += int64(num)
		if num == 0 {
			cnt1++
		}
	}
	for _, num := range nums2 {
		sum2 += int64(num)
		if num == 0 {
			cnt2++
		}
	}
	//fmt.Println(sum1,sum2,cnt1,cnt2)
	if (cnt2 == 0 && sum1+int64(cnt1) > sum2) || (cnt1 == 0 && sum1 < sum2+int64(cnt2)) {
		return ans
	}
	if sum1+int64(cnt1) > sum2+int64(cnt2) {
		ans = sum1 + int64(cnt1)
	} else if sum1+int64(cnt1) == sum2+int64(cnt2) {
		if cnt1 > cnt2 {
			ans = sum1 + int64(cnt1)
		} else {
			ans = sum2 + int64(cnt2)
		}
	} else {
		ans = sum2 + int64(cnt2)
	}
	return ans
}

// @lc code=end
