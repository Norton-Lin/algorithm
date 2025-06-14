package main

/*
 * @lc app=leetcode.cn id=2566 lang=golang
 *
 * [2566] 替换一个数字后的最大差值
 */

// @lc code=start
func MinMaxDifference(num int) int {
	maxNum, minNum := 0, 0
	tmp := num
	records := make([]int, 0)
	cnt := 1
	for tmp > 0 {
		records = append(records, tmp%10)
		tmp /= 10
	}
	n := len(records)
	tagMin := records[n-1]
	tagMax := records[n-1]
	for i := n - 2; i >= 0 && tagMax == 9; i-- {
		tagMax = records[i]
	}
	for _, num := range records {
		value := num
		if num == tagMax {
			value = 9
		}
		maxNum += cnt * value
		value = num
		if num == tagMin {
			value = 0
		}
		minNum += cnt * value
		cnt *= 10

	}
	return maxNum - minNum
}

// @lc code=end
