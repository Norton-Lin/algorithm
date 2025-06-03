package main

/*
 * @lc app=leetcode.cn id=1298 lang=golang
 *
 * [1298] 你能从盒子里获得的最大糖果数
 */

// @lc code=start
// 盒子里有盒子
// 盒子里有钥匙
// 有盒子且盒子开，盒子才能获取里面的东西
// 盒子可能天然开，或者要有钥匙
// 每次拿到钥匙，更新status数组
// 每次拿到盒子，加入initialBoxes
func MaxCandies(status []int, candies []int, keys [][]int, containedBoxes [][]int, initialBoxes []int) int {
	ans := 0
	l := 0
	cnt := 0
	for len(initialBoxes) > 0 {
		l = len(initialBoxes)
		curBox := initialBoxes[0]
		initialBoxes = initialBoxes[1:]
		if status[curBox] == 0 {
			cnt++
			initialBoxes = append(initialBoxes, curBox)
			if cnt == l {
				break
			}
			continue
		} else {
			cnt = 0
			ans += candies[curBox]
			for _, key := range keys[curBox] {
				status[key] = 1
			}
			initialBoxes = append(initialBoxes, containedBoxes[curBox]...)
		}
	}
	return ans
}

// @lc code=end
