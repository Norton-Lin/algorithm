package main

import "fmt"

/*
 * @lc app=leetcode.cn id=2327 lang=golang
 *
 * [2327] 知道秘密的人数
 */

// @lc code=start
func PeopleAwareOfSecret(n int, delay int, forget int) int {
	const mod int = 1e9 + 7
	delayQueue := make([]int, 0)
	forgetQueue := make([]int, 0)
	cur := 0
	ans := 0
	delayNum := 0
	forgetNum := 0
	for i := 0; i < delay-1; i++ {
		delayQueue = append(delayQueue, 0)
	}
	delayQueue = append(delayQueue, 1)
	for i := 0; i < forget-1; i++ {
		forgetQueue = append(forgetQueue, 0)
	}
	forgetQueue = append(forgetQueue, 1)
	for i := 1; i < n; i++ {
		delayNum = delayQueue[0]
		delayQueue = delayQueue[1:]
		forgetNum = forgetQueue[0]
		forgetQueue = forgetQueue[1:]
		cur = (cur - forgetNum + mod) % mod
		cur = (cur + delayNum + mod) % mod
		delayQueue = append(delayQueue, cur)
		forgetQueue = append(forgetQueue, cur)
		//fmt.Println(cur,delayQueue,forgetQueue)
		//fmt.Println(cur,delayNum,forgetNum)
	}
	ans = cur
	for _, num := range delayQueue {
		ans = (ans + num + mod) % mod
	}
	const test int = 310155616
	fmt.Println(test % mod)
	return ans
}

// @lc code=end
