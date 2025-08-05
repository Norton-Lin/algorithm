package main

/*
 * @lc app=leetcode.cn id=3477 lang=golang
 *
 * [3477] 水果成篮 II
 */

// @lc code=start
func NumOfUnplacedFruits(fruits []int, baskets []int) int {
	tags := make([]bool, len(fruits))
	ans := len(fruits)
	for _, fruit := range fruits {
		for i := 0; i < len(baskets); i++ {
			if tags[i] {
				continue
			}
			if fruit <= baskets[i] {
				tags[i] = true
				ans--
				break
			}
		}
	}
	return ans
}

// @lc code=end
