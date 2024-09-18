package main

import (
	"sort"
)

/*
 * @lc app=leetcode.cn id=2332 lang=golang
 *
 * [2332] 坐上公交的最晚时间
 */

// @lc code=start
func LatestTimeCatchTheBus(buses []int, passengers []int, capacity int) int {
	ans := 0
	sort.Ints(buses)
	sort.Ints(passengers)
	n := len(passengers)
	queue := make([]int, 0)
	i := 0
	j := 0
	num := 0
	record := false
	for _, bus := range buses {
		num = 0
		//乘客排队，先来后到
		for ; i < n && passengers[i] <= bus; i++ {
			queue = append(queue, i)
		}
		j = len(queue)
		//乘客上车
		for ; num < capacity && j > 0; num++ {
			j--
			queue = queue[1:]
		}
		//记录最后一辆车
		if bus == buses[len(buses)-1] {
			if num == capacity {
				record = true
			}
		}
	}
	//还有人排队
	if len(queue) > 0 {
		//挤掉最后一个上车人
		i = min(i-1, queue[0]-1)
		ans = passengers[i]
		for i >= 0 && ans == passengers[i] {
			i--
			ans--
		}
	} else { //没人排队，可能有座，可能没座位
		i = min(n-1, i-1)
		if record {
			ans = passengers[i]
			for i >= 0 && ans == passengers[i] {
				i--
				ans--
			}
		} else {
			ans = buses[len(buses)-1]
			for i >= 0 && ans == passengers[i] {
				i--
				ans--
			}
		}
	}
	return ans
}

// @lc code=end
