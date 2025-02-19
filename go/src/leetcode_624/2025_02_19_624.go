package main

/*
 * @lc app=leetcode.cn id=624 lang=golang
 *
 * [624] 数组列表中的最大距离
 */

// @lc code=start
// 给一个数组列表，求其绝对值之差最大的值
// 要求两个数不在同一数组上
// 有效值必然是最大值或最小值
// 假设 array[i][k] 和 array[j][l] 可以获得最大值
// 一方不动，另一方扩大或缩小 ans变大
// 记录所有数组中两个最大的最大值和两个最小的最小值即可
// 一次遍历，维护四个记录变量
func MaxDistance(arrays [][]int) int {
	ans := 0
	recordMin := make([][]int, 2)
	recordMax := make([][]int, 2)
	//记录两个最大值和最小值
	for i := 0; i < 2; i++ {
		recordMin[i] = make([]int, 2)
		recordMax[i] = make([]int, 2)
	}
	if arrays[0][0] <= arrays[1][0] {
		recordMin[0][0] = arrays[0][0]
		recordMin[0][1] = 0
		recordMin[1][0] = arrays[1][0]
		recordMin[1][1] = 1
	} else {
		recordMin[1][0] = arrays[0][0]
		recordMin[1][1] = 0
		recordMin[0][0] = arrays[1][0]
		recordMin[0][1] = 1
	}
	if arrays[0][len(arrays[0])-1] >= arrays[1][len(arrays[1])-1] {
		recordMax[0][0] = arrays[0][len(arrays[0])-1]
		recordMax[0][1] = 0
		recordMax[1][0] = arrays[1][len(arrays[1])-1]
		recordMax[1][1] = 1
	} else {
		recordMax[1][0] = arrays[0][len(arrays[0])-1]
		recordMax[1][1] = 0
		recordMax[0][0] = arrays[1][len(arrays[1])-1]
		recordMax[0][1] = 1
	}

	for index, arr := range arrays[2:] {
		n := len(arr)
		if arr[0] <= recordMin[0][0] {
			recordMin[1][0] = recordMin[0][0]
			recordMin[1][1] = recordMin[0][1]
			recordMin[0][0] = arr[0]
			recordMin[0][1] = index + 2
		} else if arr[0] <= recordMin[1][0] {
			recordMin[1][0] = arr[0]
			recordMin[1][1] = index + 2
		}
		if arr[n-1] >= recordMax[0][0] {
			recordMax[1][0] = recordMax[0][0]
			recordMax[1][1] = recordMax[0][1]
			recordMax[0][0] = arr[n-1]
			recordMax[0][1] = index + 2
		} else if arr[n-1] >= recordMax[1][0] {
			recordMax[1][0] = arr[n-1]
			recordMax[1][1] = index + 2
		}
	}
	//fmt.Println(recordMax,recordMin)
	if recordMax[0][1] != recordMin[0][1] {
		ans = recordMax[0][0] - recordMin[0][0]
	} else {
		ans = max(recordMax[1][0]-recordMin[0][0], recordMax[0][0]-recordMin[1][0])
	}
	return ans
}
