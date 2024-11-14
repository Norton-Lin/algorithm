package main

/*
 * @lc app=leetcode.cn id=3249 lang=golang
 *
 * [3249] 统计好节点的数目
 */

// @lc code=start
func CountGoodNodes(edges [][]int) int {
	n := len(edges) + 1
	g := make([][]int, n)
	for _, edge := range edges {
		x, y := edge[0], edge[1]
		g[x] = append(g[x], y)
		g[y] = append(g[y], x)
	}
	res := 0
	var dfs func(node, parent int) int
	dfs = func(node, parent int) int {
		valid := true
		treeSize := 0
		subTreeSize := 0

		for _, child := range g[node] {
			if child != parent { //避免重复计算
				size := dfs(child, node) //算子树
				if subTreeSize == 0 {
					subTreeSize = size
				} else if size != subTreeSize {
					valid = false
				}
				treeSize += size //子节点总数
			}
		}
		if valid {
			res++
		}
		return treeSize + 1 //所有点数
	}

	dfs(0, -1)
	return res
}

// @lc code=end
