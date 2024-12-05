package main

/*
 * @lc app=leetcode.cn id=3274 lang=golang
 *
 * [3274] 检测棋盘方格颜色是否相同
 */
func CheckTwoChessboards(coordinate1 string, coordinate2 string) bool {
	return (coordinate1[0]+coordinate1[1])%2 == (coordinate2[0]+coordinate2[1])%2
}
