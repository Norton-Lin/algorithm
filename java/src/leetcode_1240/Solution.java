package leetcode_1240;

class Solution {
    //回溯
    //设 h(m,n) 表示铺满该矩形所需的正方形的最少数目
    //h(n,m)≤max(n,m)；
    //h(n + m,m) = 1 + h(n, m) if  1≤m≤4；
    //h(n+m)=1 + h(n, m) if  3n≥m^2
	int ans;
    public int tilingRectangle(int n, int m) {
        ans = Math.max(n, m);
        boolean[][] rect = new boolean[n][m];//单元格状态
        dfs(0, 0, rect, 0);
        return ans;
    }
    //x行，y列，当前使用正方形数量
    public void dfs(int x, int y, boolean[][] rect, int cnt) {
        int n = rect.length, m = rect[0].length;
        if (cnt >= ans) //不是最优解，结束回溯
            return;   
        if (x >= n) {//到的边界，结束回溯
            ans = cnt; 
            return;
        }
        /* 检测下一行 */        
        if (y >= m) {
            dfs(x + 1, 0, rect, cnt); 
            return;
        }        
        /* 如当前已经被覆盖，则直接尝试下一个位置,逐行查看*/
        if (rect[x][y]) {
            dfs(x, y + 1, rect, cnt);
            return;
        }
    
        for (int k = Math.min(n - x, m - y); k >= 1 && isAvailable(rect, x, y, k); k--) {
            /* 将长度为 k 的正方形区域标记覆盖 */
            fillUp(rect, x, y, k, true);
            /* 跳过 k 个位置开始检测 */
            dfs(x, y + k, rect, cnt + 1);
            fillUp(rect, x, y, k, false);//回溯
        }
    }

    public boolean isAvailable(boolean[][] rect, int x, int y, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rect[x + i][y + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void fillUp(boolean[][] rect, int x, int y, int k, boolean val) {
        for (int i = 0; i < k; i++){
            for (int j = 0; j < k; j++) {
                rect[x + i][y + j] = val;
            }
        }
    }
    
}
